package practise.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Project: SomethingAboutJava
 * Package: practise.Socket
 * Author: Alan Ruan
 * Date: 2019-03-26  15:31
 * Description: //TODO
 */
public class UsefulAddress {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        final List<String> ipList = new ArrayList<>();

        try {
            String localIP = InetAddress.getLocalHost().getHostAddress();
            System.out.printf("本机IP: %s%n%n", localIP);

            //使用Java自带的线程池
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                    15, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>()
                    );

            for (int i = 0;i < 255 ; i++){
                final String testIP = String.format("%s%d",
                        localIP.substring(0, localIP.lastIndexOf(".") + 1), i+1);
                if (testIP.equals(localIP)){
                    continue;
                }

//                System.out.println(testIP);

                threadPoolExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.printf("[%S]正在测试ip: %s ... %n", Thread.currentThread().getName(), testIP);
                        //判断是否可以连接
                        boolean isConn = true;
                        Process process = null;

                        try {
                            process = Runtime.getRuntime().exec(String.format("ping %s", testIP));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        BufferedReader bufferedReader = new BufferedReader(
                                new InputStreamReader(process.getInputStream(), Charset.forName("GBK"))
                        );

                        String buffer = null;

                        try {
                            while ((buffer = bufferedReader.readLine()) != null){
                                isConn = buffer.indexOf("请求超时。") == -1;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if (isConn){
                            ipList.add(testIP);
                        }

                        System.out.printf("[%S]完成测试ip: %s!%n", Thread.currentThread().getName(), testIP);

                    }
                });

                threadPoolExecutor.shutdown();

                while (true){
                    if (threadPoolExecutor.isTerminated()){
                        break;
                    }
                }

                long endTime = System.currentTimeMillis();
                System.out.printf("完成测试， 耗时（%s秒），共计%d个IP可以连接，%n", (endTime-startTime)/1000,
                        ipList.size());

                for (String s: ipList){
                    System.out.println(s);
                }


            }



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}

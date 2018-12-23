package java_basic;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Project:Exercise
 * Package:main.java.java_basic
 * Author:Alan Ruan
 * Date:2018-11-09 15:22
 * Description://TODO
 */
public class CallableImpl implements Callable<String> {

    private String acceptStr;

    public CallableImpl(String acceptStr) {
        this.acceptStr = acceptStr;
    }


    @Override
    public String call() throws Exception {
        // 任务阻塞1秒，并且增加一些信息返回
        Thread.sleep(1000);
        return this.acceptStr + " 增加一些字符并返回";
    }

    public static void main(String[] args) throws Exception {

        Callable<String> callable = new CallableImpl("Callable测试");
        FutureTask<String> task = new FutureTask<String>(callable);
        // 创建线程
        new Thread(task).start();
        long beginTime = System.currentTimeMillis();
        // 调用get()阻塞主线程，反之，线程不会阻塞
        String result = task.get();
        long endTime = System.currentTimeMillis();
        System.out.println("hello : " + result);

        // endTime 和 beginTime是不一样的，因为阻塞了主线程
        System.out.println("cast : " + (endTime - beginTime) / 1000 + " second!");
    }
}


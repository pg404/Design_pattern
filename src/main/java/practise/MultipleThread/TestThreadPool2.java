package practise.MultipleThread;

/**
 * Project: SomethingAboutJava
 * Package: practise.MultipleThread
 * Author: Alan Ruan
 * Date: 2019-03-22  17:05
 * Description: //TODO
 */
public class TestThreadPool2 {

    public static void main(String[] args) {

        ThreadPool pool = new ThreadPool();
        int sleep = 1000;
        while (true){
            pool.add(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行了任务");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            try {
                Thread.sleep(sleep);
                sleep = sleep >  100? sleep-100 : sleep;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

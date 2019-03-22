package practise.MultipleThread;

/**
 * Project: SomethingAboutJava
 * Package: practise.MultipleThread
 * Author: Alan Ruan
 * Date: 2019-03-22  16:55
 * Description: //TODO
 */
public class TestThreadPool {

    public static void main(String[] args) {

        ThreadPool pool = new ThreadPool();
        for (int i = 0; i < 5; i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务");
                }
            };
            pool.add(task);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

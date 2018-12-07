package main.java.concurrent.act_of_concurrent.chapter4;

/**
 * Project:Exercise
 * Package:main.java.concurrent.act_of_concurrent.chapter4
 * Author:Alan Ruan
 * Date:2018-10-29 16:50
 * Description://TODO
 */
public class Daemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }
    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }

}

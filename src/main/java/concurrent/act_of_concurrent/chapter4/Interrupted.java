package main.java.concurrent.act_of_concurrent.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Project:Exercise
 * Package:main.java.concurrent.act_of_concurrent.chapter4
 * Author:Alan Ruan
 * Date:2018-10-29 16:53
 * Description://TODO
 */
public class Interrupted {

    public static void main(String[] args) throws Exception {
// sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
// busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
// 休眠5秒，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
// 防止sleepThread和busyThread立刻退出
        SleepUtils.second(2);
    }
    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }
    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

}

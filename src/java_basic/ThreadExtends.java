package java_basic;

/**
 * Project:Exercise
 * Package:java_basic
 * Author:Alan Ruan
 * Date:2018-11-09 15:17
 * Description://TODO
 */
public class ThreadExtends {
    public static void main(String[] args) {
        new MyThread("Thread测试").start();
        new MyThread("Thread测试").start();
    }
}

class MyThread extends Thread{

    private String acceptStr;

    public MyThread(String acceptStr) {
        this.acceptStr = acceptStr;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i ++) {
            System.out.println("这个传给我的值："+acceptStr+",加上一个变量，看看是什么效果："+i);
        }
    }
}


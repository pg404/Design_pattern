package concurrent.act_of_concurrent.chapter1;

/**
 * Project:Exercise
 * Package:main.java.concurrent.act_of_concurrent.chapter1
 * Author:Alan Ruan
 * Date:2018-10-29 16:02
 * Description://TODO
 */
public class DeadLockDemo {

    private static String A="A";
    private static String B="B";

    public static void main(String[] args){
        new DeadLockDemo().deadLocak();

    }

    private void deadLocak(){

        Thread th1=new Thread(() -> {
            synchronized (A){
                try {
                    Thread.currentThread().sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println(1);
                }
            }
        });

        Thread th2=new Thread(() -> {
            synchronized (B){
                synchronized (A){
                    System.out.println(2);
                }
            }
        });

        th1.start();
        th2.start();

    }

}

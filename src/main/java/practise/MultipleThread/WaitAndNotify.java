package practise.MultipleThread;

/**
 * Project: SomethingAboutJava
 * Package: practise.MultipleThread
 * Author: Alan Ruan
 * Date: 2019-03-22  16:46
 * Description: //TODO
 */
public class WaitAndNotify {

    public static void main(String[] args) {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 66;

        Thread t1 = new Thread(){
            @Override
            public void run(){
                while(true){

                    //无需循环判断
//                    while(gareen.hp==1){
//                        continue;
//                    }

                    gareen.hurt();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t1.start();


        Thread t2 = new Thread(){
            @Override
            public void run(){
                while(true){
                    gareen.recover();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        };
        t2.start();

    }

}

package java_basic;

/**
 * Project:Exercise
 * Package:java_basic
 * Author:Alan Ruan
 * Date:2018-11-09 15:20
 * Description://TODO
 */
public class RunableImpl implements Runnable {

    private String acceptStr;

    public RunableImpl(String acceptStr) {
        this.acceptStr = acceptStr;
    }

    @Override
    public void run() {
        try {
            // 线程阻塞1秒，此时有异常产生，只能在方法内部消化，无法上抛
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 最终处理结果无法返回
        System.out.println("hello : " + this.acceptStr);
    }

    public static void main(String[] args) {
        Runnable runnable = new RunableImpl("Runable测试");
        long beginTime = System.currentTimeMillis();
        new Thread(runnable).start();
        long endTime = System.currentTimeMillis();

        // endTime 和 beginTime是一样的，线程并不会阻塞主线程
        System.out.println("cast : " + (endTime - beginTime) / 1000 + " second!");
    }
}


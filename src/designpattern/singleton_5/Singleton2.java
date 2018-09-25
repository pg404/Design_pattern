package designpattern.singleton_5;

/**
 * Project:Exercise
 * Package:designpattern.singleton_5
 * Author:Alan Ruan
 * Date:2018-09-24 00:27
 * Description://TODO  用双重检查加锁，在getInstance()中减少使用同步
 */
public class Singleton2 {


    private volatile static Singleton2 uniqueInstance;

    private Singleton2(){
    }

    public static Singleton2 getInstance(){  //注意，只有第一次才会彻底执行这里的代码。
        if (uniqueInstance == null){         //检查实例，如果不存在就进入同步块。
            synchronized (Singleton2.class){
                if (uniqueInstance == null){   //进入同步区块后，再检查一次，如果仍然是null，才创建实例
                    uniqueInstance = new Singleton2();
                }
            }
        }
        return uniqueInstance;
    }


}

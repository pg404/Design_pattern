package design_pattern.singleton_5;

/**
 * Project:Exercise
 * Package:design_pattern.singleton_5
 * Author:Alan Ruan
 * Date:2018-09-24 00:22
 * Description://TODO  使用synchronized关键字处理多线程，但是非常影响效率
 */
public class Singleton {

    private static Singleton uniqueInstance;

    private Singleton(){}

    public static synchronized Singleton getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }


}

package design_pattern.singleton_5;

/**
 * Project:Exercise
 * Package:design_pattern.singleton_5
 * Author:Alan Ruan
 * Date:2018-09-24 00:25
 * Description://TODO 使用急切创建实例，而不用延迟实例化的做法
 */
public class Singleton1 {

    private static Singleton1 uniqueInstance = new Singleton1();

    private Singleton1(){
    }

    public static Singleton1 getInstance(){
        return uniqueInstance;
    }


}
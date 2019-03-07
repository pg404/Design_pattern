package algorithm.algorithm_of_剑指offer;

/**
 * Project:Exercise
 * Package:main.java.algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-21 09:53
 * Description://TODO
 */
//饱汉模式  它的构造函数为private的，它有一个static的private的该类变量，在类初始化时实例话，通过一个public的getInstance方法获取对它的引用,继而调用其中的方法

public class Singleton {

    private Singleton(){}

    private final static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }

}


//饿汉模式
class Singleton2{

    private static Singleton2 singleton2 = null;
    //这个方法比上面有所改进，不用每次都进行生成对象，只是第一次　　　 　
    //使用时生成实例，提高了效率！
    public static synchronized Singleton2 getSingleton2(){
        if (singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

}

package practise.reflection;

/**
 * Project: SomethingAboutJava
 * Package: practise.reflection
 * Author: Alan Ruan
 * Date: 2019-03-22  17:19
 * Description: //TODO  在理解类对象之前，先说我们熟悉的对象之间的区别：
 * garen和teemo都是Hero对象，他们的区别在于，各自有不同的名称，血量，伤害值。
 *
 * 然后说说类之间的区别
 * Hero和Item都是类，他们的区别在于有不同的方法，不同的属性。
 *
 * 类对象，就是用于描述这种类，都有什么属性，什么方法的
 *
 * 获取类对象有3种方式
 * 1. Class.forName
 * 2. Hero.class
 * 3. new Hero().getClass()
 *
 * 在一个JVM中，一种类，只会有一个类对象存在。所以以上三种方式取出来的类对象，都是一样的
 *
 */
public class ClassObject {

    public static void main(String[] args) {

        String className = "practise.reflection.Hero";

        try {
            Class class1 = Class.forName(className);
            Class class2 = Hero.class;
            Class class3 = new Hero().getClass();

            //获取类对象的时候，会导致类属性被初始化

//            无论什么途径获取类对象，都会导致静态属性被初始化，而且只会执行一次。（
//            除了直接使用 Class c = Hero.class 这种方式，这种方式不会导致静态属性被初始化）

            System.out.println(class1 == class2);
            System.out.println(class2 == class3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

}

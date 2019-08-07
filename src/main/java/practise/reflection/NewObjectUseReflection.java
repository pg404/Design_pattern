package practise.reflection;

import java.lang.reflect.Constructor;

/**
 * Project: SomethingAboutJava
 * Package: practise.reflection
 * Author: Alan Ruan
 * Date: 2019-03-22  17:31
 * Description: //TODO 通过反射机制创建一个对象
 */
public class NewObjectUseReflection {

    public static void main(String[] args) {
        //传统的使用new的方式创建对象
        Hero h1 =new Hero();
        h1.name = "teemo";
        System.out.println(h1.toString());

        try {
            String className = "practise.reflection.Hero";
            Class c = Class.forName(className);
            Constructor constructor = c.getConstructor();

            Hero h2 = (Hero)c.newInstance();
            h2.name = "gareen";
            System.out.println(h2.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

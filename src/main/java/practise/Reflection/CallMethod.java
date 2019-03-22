package practise.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Project: SomethingAboutJava
 * Package: practise.Reflection
 * Author: Alan Ruan
 * Date: 2019-03-22  17:47
 * Description: //TODO
 */
public class CallMethod {

    public static void main(String[] args) {

        Hero hero = new Hero();

        try {
            // 获取这个名字叫做setName，参数类型是String的方法
            Method method = hero.getClass().getMethod("setName", String.class);
            // 对h对象，调用这个方法
            method.invoke(hero, "我是我自己");
            // 使用传统的方式，调用getName方法
            System.out.println(hero.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}

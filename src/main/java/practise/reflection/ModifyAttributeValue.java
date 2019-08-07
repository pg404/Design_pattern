package practise.reflection;

import java.lang.reflect.Field;

/**
 * Project: SomethingAboutJava
 * Package: practise.reflection
 * Author: Alan Ruan
 * Date: 2019-03-22  17:42
 * Description: //TODO 通过反射修改属性的值
 *
 *
 * getField和getDeclaredField的区别
 * 这两个方法都是用于获取字段
 * getField 只能获取public的，包括从父类继承来的字段。
 * getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。
 * (注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true))
 *
 *
 */
public class ModifyAttributeValue {

    public static void main(String[] args) {

        Hero hero = new Hero();
        //使用传统方式修改name的值为garen
        hero.name= "Alan";

        try {
            //获取类Hero的名字叫做name的字段
            Field field = hero.getClass().getDeclaredField("name");
            //修改这个字段的值
            field.set(hero, "Garen");
            //打印被修改后的值
            System.out.println(hero.name);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}

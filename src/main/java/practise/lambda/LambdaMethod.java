package practise.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Project: SomethingAboutJava
 * Package: practise.lambda
 * Author: Alan Ruan
 * Date: 2019-03-20  20:14
 * Description: //TODO Lambda方式
 * 使用Lambda方式筛选出数据
 *
 * filter(heroes,(h)->h.hp>100 && h.damage<50);
 *
 *
 * 同样是调用filter方法，从上一步的传递匿名类对象，变成了传递一个Lambda表达式进去
 *
 * h->h.hp>100 && h.damage<50
 */
public class LambdaMethod {

    public static void main(String[] args) {

        Random r = new Random();
        List<Hero> heroes = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heroes.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heroes);
        System.out.println("使用Lamdba的方式，筛选出 hp>100 && damange<50的英雄");

        filter(heroes, h -> h.hp > 100 && h.damage < 50);

    }

    /*
    * 与匿名类 概念相比较，
       lambda 其实就是匿名方法，这是一种把方法作为参数进行传递的编程思想。
        虽然代码是这么写
        filter(heros, h -> h.hp > 100 && h.damage < 50);
        但是，Java会在背后，悄悄的，把这些都还原成匿名类方式。
        引入Lambda表达式，会使得代码更加紧凑，而不是各种接口和匿名类到处飞。
    * */

    private static void filter(List<Hero> heroes,HeroChecker checker) {
        for (Hero hero : heroes) {
            if(checker.test(hero))
            {
                System.out.print(hero);
            }
        }
    }

}

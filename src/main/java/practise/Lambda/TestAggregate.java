package practise.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Project: SomethingAboutJava
 * Package: practise.Lambda
 * Author: Alan Ruan
 * Date: 2019-03-21  19:24
 * Description: //TODO  遍历数据的传统方式就是使用for循环，然后条件判断，最后打印出满足条件的数据
 *
 * for (Hero h : heros) {
 *    if (h.hp > 100 && h.damage < 50)
 *       System.out.println(h.name);
 * }
 *
 * 使用聚合操作方式，画风就发生了变化
 *
 * heros
 * 	.stream()
 * 	.filter(h -> h.hp > 100 && h.damage < 50)
 * 	.forEach(h -> System.out.println(h.name));
 *
 */
public class TestAggregate {

    public static void main(String[] args) {

        Random r = new Random();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 1; i < 10; i++){
            heroes.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }

        System.out.println("初始化后的集合：");
        System.out.println(heroes);
        System.out.println("查询条件：hp>100 && damage<50");
        System.out.println("通过传统操作方式找出满足条件的数据：");

        for (Hero h : heroes){
            if (h.hp > 100 && h.damage < 50)
            {
                System.out.println(h.name);
            }
        }

        System.out.println("通过聚合操作方式找出满足条件的数据：");
        heroes.stream()
                .filter(h -> h.hp > 100 && h.damage < 50)
                .forEach(h -> System.out.println(h.name));

    }

}

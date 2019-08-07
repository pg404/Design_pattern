package practise.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Project: SomethingAboutJava
 * Package: practise.lambda
 * Author: Alan Ruan
 * Date: 2019-03-20  19:50
 * Description: //TODO 使用一个普通方法，在for循环遍历中进行条件判断，筛选出满足条件的数据
 */
public class NormalMethod {

    public static void main(String[] args) {

        Random r = new Random();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            heroes.add(new Hero("hero " + i, r.nextInt(1000),r.nextInt(100)));
        }

        System.out.println("初始化后的集合：");
        System.out.println(heroes);
        System.out.println("筛选出 hp>100 && damange<50的英雄");

        filter(heroes);
    }


    private static void filter(List<Hero> heroes) {
        for (Hero hero : heroes) {
            if(hero.hp>100 && hero.damage<50)
            {
                System.out.print(hero);
            }
        }
    }

}

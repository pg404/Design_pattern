package practise.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Project: SomethingAboutJava
 * Package: practise.lambda
 * Author: Alan Ruan
 * Date: 2019-03-21  19:35
 * Description: //TODO
 * 要了解聚合操作，首先要建立Stream和管道的概念
 * Stream 和Collection结构化的数据不一样，Stream是一系列的元素，就像是生产线上的罐头一样，一串串的出来。
 * 管道指的是一系列的聚合操作。
 *
 * 把Collection切换成管道源很简单，调用stream()就行了。
 *
 * heros.stream()
 *
 *
 * 但是数组却没有stream()方法，需要使用
 *
 * Arrays.stream(hs)
 *
 *
 * 或者
 *
 * Stream.of(hs)
 *
 *
 */
public class Stream {

    public static void main(String[] args) {

        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }

        //管道源是集合
        heros.stream()
                .forEach(h -> System.out.println(h.name));


        //管道源是数组
        Hero hs[] = heros.toArray(new Hero[heros.size()]);
        Arrays.stream(hs)
                .forEach(h -> System.out.println(h.name));

    }

}

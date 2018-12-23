package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Project: SomethingAboutJava
 * Package: test
 * Author: Alan Ruan
 * Date: 2018-12-21  18:03
 * Description: //TODO
 */
public class ListRemove {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            list.add(i);
        }

        /*
        for (Integer i: list){
            if (i==5){
                list.remove(5);//这里是一个错误的例子，当调用list本身的remove方法时，此时因为，
                //调用list.remove()方法导致modCount和expectedModCount的值不一致。
                //会抛出ConcurrentModificationException异常
            }
            System.out.println(i);
        }
        */

        //正确方法应当调用Iterator的remove方法，不过在这个方法中，删除元素实际上调用的就是list.remove()方法，但是它多了一个操作：
        //expectedModCount = modCount;

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next == 5){
                iterator.remove();
            }
            System.out.println(next);
        }

        //参考资料：https://www.cnblogs.com/dolphin0520/p/3933551.html
        //  https://segmentfault.com/a/1190000011411407
    }

}

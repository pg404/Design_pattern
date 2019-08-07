package practise.multipleThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project: SomethingAboutJava
 * Package: practise.multipleThread
 * Author: Alan Ruan
 * Date: 2019-03-22  16:28
 * Description: //TODO  ArrayList是非线程安全的，换句话说，多个线程可以同时进入一个ArrayList对象的add方法
 *
 * 借助Collections.synchronizedList，可以把ArrayList转换为线程安全的List。
 *
 * 与此类似的，还有HashSet,LinkedList,HashMap等等非线程安全的类，都通过工具类Collections转换为线程安全的
 *
 *
 */
public class ChangeToSynchronized {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = Collections.synchronizedList(list1);
    }

}

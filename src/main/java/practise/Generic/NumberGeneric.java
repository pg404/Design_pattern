package practise.Generic;

import java.util.ArrayList;

/**
 * Project: SomethingAboutJava
 * Package: practise.Generic
 * Author: Alan Ruan
 * Date: 2019-03-21  19:52
 * Description: //TODO 根据数字类的知识，设计一个集合，这个集合里即可以放整数，也可以放浮点数，但是不能放字符串
 */
public class NumberGeneric {

    public static void main(String[] args) {

        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add(3.12);
        numbers.add(1);
//        numbers.add("fad");
        System.out.println(numbers.get(0));
    }

}

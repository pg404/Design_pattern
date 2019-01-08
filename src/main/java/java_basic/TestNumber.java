package java_basic;

/**
 * Project: SomethingAboutJava
 * Package: java_basic
 * Author: Alan Ruan
 * Date: 2019-01-08  11:17
 * Description: //TODO
 */
public class TestNumber {

    public static void main(String[] args) {

        int i = 542342;
        Integer integer = new Integer(i);
        int i2 = integer.intValue();
        System.out.println(i2);

        //Byte, Short, Float, Double, Integer, Long都是Number的子类
        System.out.println(integer instanceof  Number);

        //自动转换就叫做装箱
        Integer i3 = i;

        //同理，这是自动拆箱
        int i4 = integer;

        //查看int的最大最小值
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        String string = String.valueOf(i);

        int i5 = Integer.parseInt(string);
//        float f = Float.parseFloat("3.1a4");
//        System.out.println(f);



    }

}

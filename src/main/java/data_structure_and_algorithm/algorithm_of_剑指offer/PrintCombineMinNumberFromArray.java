package main.java.data_structure_and_algorithm.algorithm_of_剑指offer;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-26 16:52
 * Description://TODO 33.输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 思路：先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就
 * 是制定排序规则。或使用比较和快排的思想，将前面的数和最后的数比较，若小则放到最前面，最后再递归调
 * 用。
 */
public class PrintCombineMinNumberFromArray {

    public static void main(String[] args){

        int[] a ={3,1,2,4};
        System.out.println(printMinNumber(a));

    }

    public static String printMinNumber(int[] number){

        if (number == null || number.length == 0){
            return "";
        }
        int len = number.length;
        String[] str = new String[len];

        StringBuilder stringBuilder = new StringBuilder();
        for (int i= 0; i < len; i++){
            str[i] = String.valueOf(number[i]);
        }

        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });

        for (int i= 0;i < len; i++){
            stringBuilder.append(str[i]);
        }

        return stringBuilder.toString();
    }

}

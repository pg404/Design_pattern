package main.java.data_structure_and_algorithm.algorithm_of_剑指offer;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-26 20:29
 * Description://TODO 35.在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 思路：利用LinkedHashMap保存字符和出现次数。
 *
 *
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = scanner.next();


        System.out.println("该字符串中第一个只出现一次的字符位于第" + findFirstNotRepeatingChar(s)+ "位，这个字符是："
        + s.charAt(findFirstNotRepeatingChar(s)));

    }

    public static int findFirstNotRepeatingChar(String string){
        if (string == null || string.length() == 0){
            return -1;
        }
        char[] chars = string.toCharArray();
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();

        for (char item: chars){
            if (hashMap.containsKey(item)){
                hashMap.put(item, hashMap.get(item) + 1);
            }else {
                hashMap.put(item, 1);
            }
        }

        for (int i =0; i < string.length(); i++){
            if (hashMap.get(string.charAt(i)) == 1 ){
                return i;
            }
        }

        return -1;
    }

}

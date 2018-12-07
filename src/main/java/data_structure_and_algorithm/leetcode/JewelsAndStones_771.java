package main.java.data_structure_and_algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.leetcode
 * Author:Alan Ruan
 * Date:2018-12-06 10:48
 * Description://TODO 771. Jewels and Stones
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class JewelsAndStones_771 {

    public static void main(String[] args) {

        System.out.println(numJewelsInStones("aH", "aczcfaH"));
        System.out.println(numJewelsInStones1("aH", "aczcfaH"));
        System.out.println(numJewelsInStones2("aH", "aczcfaH"));
    }

    //用hashset
    public static int numJewelsInStones(String J, String S) {

        Set<Character> jewel = new HashSet<>();
        for (char c : J.toCharArray()) {
            jewel.add(c);
        }
        int count = 0;
        for (char b : S.toCharArray()) {
            if (jewel.contains(b)) {
                count++;
            }
        }

        return count;

    }

    //直接嵌套循环
    public static int numJewelsInStones1(String J, String S) {
        int count = 0;

        //its for jewel string
        for (int i = 0; i < J.length(); i++) {
            //its for stone stringSJ
            for (int j = 0; j < S.length(); j++) {
                //here we check does stones matches with jewel
                //if match then we will increment count
                if (J.charAt(i) == S.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    //利用indexOf函数
    //字符串的IndexOf()方法搜索在该字符串上是否出现了作为参数传递的字符串
    //如果找到字符串,则返回字符的起始位置
    //0表示第一个字符,1表示第二个字符依此类推，
    //如果说没有找到则返回-1

    // http://www.cnblogs.com/davyli/articles/1137697.html

    public static int numJewelsInStones2(String J, String S) {
        int count=0;
        for(char c : S.toCharArray()){
            if(J.indexOf(c) != -1){
                count++;
            }
        }
        return count;
    }


}

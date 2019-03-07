package algorithm.algorithm_of_剑指offer;

import static algorithm.algorithm_of_剑指offer.ReverseSentence.reverse;

/**
 * Project:Exercise
 * Package:main.java.algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-12-08 16:20
 * Description://TODO 1对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
 */
public class LeftRotateString {

    public static void main(String[] args) {

        String s = "abcdefg";
        System.out.println(leftRotate(s,4));

    }

    private static String leftRotate(String str, int n){
        if (str == null || str.length() == 0){
            return str;
        }
        String s1 = reverse(str.substring(0, n));
        String s2 = reverse(str.substring(n, str.length()));
        return reverse(s2) + reverse(s1);
    }

}

package algorithm.algorithm_of_剑指offer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Project:Exercise
 * Package:main.java.algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-26 16:22
 * Description://TODO 28.输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所
 * 能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 *
 * 思路：将当前位置的字符和前一个字符位置交换，递归。
 */
public class CharacterPermutation {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串: ");
        String s = scanner.next();
        ArrayList<String> arrayList = Permutation(s);
        System.out.println("该字符串能组成的字符串有： ");
        for (String i: arrayList){
            System.out.print(i + " ");
        }

    }

    public static ArrayList<String> Permutation(String string){
        ArrayList<String> result = new ArrayList<>();
        if (string == null || string.length() == 0){
            return result;
        }
        char[] chars = string.toCharArray();
        TreeSet<String> temp = new TreeSet<>();
        permutation(chars, 0, temp);
        result.addAll(temp);
        return result;
    }

    public static void swap(char[] c, int a, int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    public static void permutation(char[] chars, int index, TreeSet<String> result){

        if (chars == null || chars.length == 0){
            return;
        }
        if (index < 0 || index > chars.length - 1){
            return;
        }
        if (index == chars.length - 1){
            result.add(String.valueOf(chars));
        }else {
            for (int i = index; i <= chars.length - 1; i++){
                swap(chars, index, i);
                permutation(chars, index + 1, result);
                swap(chars, index, i);
            }
        }



    }


}

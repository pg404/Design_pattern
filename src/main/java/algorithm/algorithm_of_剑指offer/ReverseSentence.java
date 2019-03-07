package algorithm.algorithm_of_剑指offer;

import java.util.Scanner;

/**
 * Project:Exercise
 * Package:main.java.algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-12-08 15:42
 * Description://TODO  42.翻转字符串
 * 思路：先将整个字符串翻转，然后将每个单词翻转。
 */
public class ReverseSentence {

    public static void main(String[] args) {
        System.out.println("输入字符串");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n逆置字符串为：\n" + reverseTheSentence(scanner.nextLine()));
    }

    private static String reverseTheSentence(String str){
        if (str == null || str.length() == 0){
            return str;
        }
        if (str.trim().length() == 0){
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String re = reverse(str);
        String[] strings = re.split(" ");
        //前length-1个字符串，分别逆置加入
        for (int i = 0; i < strings.length - 1; i++){
            stringBuilder.append(reverse(strings[i]) + " ");
        }
        //还有最后一个字符串
        stringBuilder.append(reverse(strings[strings.length - 1]));
        return String.valueOf(stringBuilder);

    }

    public static String reverse (String str){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--){
            stringBuilder.append(str.charAt(i));
        }
        return String.valueOf(stringBuilder);
    }

}

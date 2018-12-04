package data_structure_and_algorithm.essential_algorithm_of_leetcode.字符串;

import java.util.Scanner;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm.essential_algorithm_of_leetcode.字符串
 * Author:Alan Ruan
 * Date:2018-12-03 13:48
 * Description://TODO  Valid Palindrome
 * 描述
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring
 * cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
 * Note: Have you consider that the string might be empty? This is a good question to ask during an
 * interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {

    public static void main(String[] args) {

        System.out.println("请输入一行字符串：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (isPalindrome(s)){
            System.out.println("该字符串是回文串");
        }else {
            System.out.println("不是回文串");
        }

    }

    /**
     * @Method isPalindrome
     * @Description //TODO 判断是否回文串
     * @Author Alan Ruan
     * @Date 2018/12/03 18:30:52
     * @Param [s]
     * @Return boolean
     */
    public static boolean isPalindrome(String s){
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            if (!Character.isLetterOrDigit(s.charAt(left)) ){
                ++left;
            }else if (!Character.isLetterOrDigit(s.charAt(right))){
                --right;
            }else if (s.charAt(left) != s.charAt(right)){
                return false;
            }else {
                ++left;
                --right;
            }
        }
        return true;
    }

}

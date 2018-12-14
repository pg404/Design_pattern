package main.java.data_structure_and_algorithm.essential_algorithm_of_leetcode.字符串;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.essential_algorithm_of_leetcode.字符串
 * Author:Alan Ruan
 * Date:2018-12-10 15:47
 * Description://TODO  // Assume you have a method isSubstring which checks if one word is a isSubstring of another.
 * // Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only
 * // one call to isSubstring(e.g., "waterbottle" is a rotation of "erbottlewat").
 */
public class IsRotation {

    public static void main(String[] args) {

    }

    private static boolean isRotation(String s1, String s2){
        int len = s1.length();
        if (len == s2.length() && len > 0){
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }

        return false;
    }

    private static boolean isSubstring(String s1, String s2){

        //没写完
        return false;
    }

}

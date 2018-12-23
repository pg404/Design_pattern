package data_structure_and_algorithm.leetcode;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.leetcode
 * Author:Alan Ruan
 * Date:2018-12-06 15:02
 * Description://TODO Implement function ToLowerCase() that has a string parameter str,
 * and returns the same string in lowercase
 */
public class ToLowerCase_709 {

    public static void main(String[] args) {

        System.out.println(toLowerCase("HellO"));
        System.out.println(toLowerCase1("hELLo"));

    }

    //用StringBuilder

    public static String toLowerCase(String str){

        StringBuilder builder = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                builder.append((char) ('a' + (c - 'A')));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();

    }


    //用数组
    public static String toLowerCase1(String string){
        char[] a = string.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if ('A' <= a[i] && a[i] <= 'Z') {
                a[i] = (char) (a[i] - 'A' + 'a');
            }
        }
        return new String(a);
    }

}

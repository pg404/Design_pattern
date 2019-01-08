package data_structure_and_algorithm.leetcode;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm.leetcode
 * Author:Alan Ruan
 * Date:2019-01-08 15:09
 * Description://TODO  Given an array nums, write a function to move all 0's
 * to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeroes_283 {

    public static void main(String[] args) {
        int[] a = {1,2,20,0,3,0,7,4,0,4,0,1};
        System.out.println("转换前：");
        output(a);
        System.out.println("转换后：");
        output(moveZeroes(a));

    }

    public static int[] moveZeroes(int[] a){

        if (a.length == 0 || a == null){
            return a;
        }

            int insertPos = 0;
        for (Integer num : a){
            if (num != 0){
                a[insertPos++] = num;
            }
        }

        while (insertPos < a.length){
            a[insertPos++] = 0;
        }

        return a;
    }

    public static void output(int[] a){
        for (Integer i : a){
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }


}

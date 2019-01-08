package data_structure_and_algorithm.leetcode;

/**
 * Project:SomethingAboutJava
 * Package:data_structure_and_algorithm.leetcode
 * Author:Alan Ruan
 * Date:2019-01-08 16:20
 * Description://TODO 283. Move Zeroes
 * Given an array nums, write a function to
 * move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeroes_283 {

    public static void main(String[] args) {
        int[] A = {1,0,2,0,3,0,4,0,5,0};
        System.out.println("转换前：");
        arrayOutput(A);
        System.out.println("转换后：");
        arrayOutput(moveZeroes2(A));
    }

    public static int[] moveZeroes(int[] A){
        if (A == null || A.length == 0){
            return A;
        }
        int insertPos = 0;
        for (Integer num : A){
            if (num != 0){
                A[insertPos++] = num;
            }
        }
        while (insertPos < A.length){
            A[insertPos++] = 0;
        }
        return A;
    }

    public static int[] moveZeroes2(int[] nums) {

        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return nums;
    }

    public static void arrayOutput(int[] a){
        for (Integer i : a){
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

}

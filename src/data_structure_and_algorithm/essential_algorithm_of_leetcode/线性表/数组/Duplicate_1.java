package data_structure_and_algorithm.essential_algorithm_of_leetcode.线性表.数组;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm.essential_algorithm_of_leetcode.线性表.数组
 * Author:Alan Ruan
 * Date:2018-11-20 20:10
 * Description://TODO  Remove Duplicates from Sorted Array
 * 描述
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return
 * the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array A = [1,1,2] ,
 * Your function should return length = 2, and A is now [1,2] .
 *
 */
public class Duplicate_1 {


    public static void main(String[] args){

        int[] a = {1,2,2,3,3,3};
        System.out.println(removeDuplicates(a));

    }



    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index-1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}

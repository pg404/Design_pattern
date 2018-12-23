package data_structure_and_algorithm.essential_algorithm_of_leetcode.线性表.数组;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.essential_algorithm_of_leetcode.线性表.数组
 * Author:Alan Ruan
 * Date:2018-11-27 21:32
 * Description://TODO Remove Duplicates from Sorted Array II
 * 描述
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 * For example, given sorted array A = [1,1,1,2,2,3] , your function should return length = 5 , and A is
 * now [1,1,2,2,3]
 * 分析
 * 加一个变量记录一下元素出现的次数即可。这题因为是已经排序的数组，所以一个变量即可解决。如果是
 * 没有排序的数组，则需要引入一个hashmap来记录出现次数。
 */
public class Duplicate_2 {

    public static void main(String[] args) {
        int[] a = {1,2,2,3,3,3};
        System.out.println(removeDuplicate(a));
    }

    public static int removeDuplicate(int[] nums){
        if (nums.length <= 2){
            return nums.length;
        }
        int index = 2;
        for (int i = 2; i < nums.length; i++){
            if (nums[i] != nums[index - 2]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}

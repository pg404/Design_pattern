package algorithm.essential_algorithm_of_leetcode.查找;

/**
 * Project:Exercise
 * Package:main.java.algorithm.essential_algorithm_of_leetcode.查找
 * Author:Alan Ruan
 * Date:2018-12-04 11:05
 * Description://TODO Search for a Range
 * 描述
 * Given a sorted array of integers, find the starting and ending position of a given target value
 * Your algorithm's runtime complexity must be in the order of O(log n) .
 * If the target is not found in the array, return [-1, -1] .
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4] .
 * 分析
 * 已经排好了序，用二分查找。
 */
public class SearchRange {

    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        System.out.println(searchRange(nums,8).toString());

    }


    public static int[] searchRange(int[] nums, int target){

        int lower = lower_bound(nums,0,nums.length, target);
        int upper = upper_bound(nums,0,nums.length, target);

        if (lower == nums.length || nums[lower] != target){
            return new int[]{-1,-1};
        }else {
            return new int[]{lower,upper -1};
        }

    }

    private static int lower_bound (int[] A, int first, int last, int target) {
        while (first != last) {
            int mid = first + (last - first) / 2;
            if (target > A[mid]) {
                first = ++mid;
            }
            else {
                last = mid;
            }
        }
        return first;
    }
    private static int upper_bound (int[] A, int first, int last, int target) {
        while (first != last) {
            int mid = first + (last - first) / 2;
            if (target >= A[mid]) {
                first = ++mid; // 与 lower_bound 仅此不同
            }
            else {
                last = mid;
            }
        }
        return first;
    }

}

package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Project:Exercise
 * Package:main.java.algorithm.leetcode
 * Author:Alan Ruan
 * Date:2018-12-06 15:34
 * Description://TODO Given an array of integers, return indices of the two numbers such that
 * they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice
 */
public class TwoSum_1 {

    public static void main(String[] args) {
        int[] array = {1,3,2,4,8,7,5};
        int[] result = twoSum(array, 12);
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    private static int[] twoSum(int[] numbers, int target){

        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;

    }

}

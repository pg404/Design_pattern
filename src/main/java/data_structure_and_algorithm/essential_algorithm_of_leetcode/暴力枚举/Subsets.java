package data_structure_and_algorithm.essential_algorithm_of_leetcode.暴力枚举;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.essential_algorithm_of_leetcode.暴力枚举
 * Author:Alan Ruan
 * Date:2018-12-04 10:38
 * Description://TODO  描述
 * Given a set of distinct integers, S , return all possible subsets.
 * Note :
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example, If S = [1,2,3] , a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {

    public static void main(String[] args) {

        int[] s = {1,2,3};
        System.out.println("递归：" + subsets1(s).toString() + "\n");
        System.out.println("位向量：" + subsets2(s).toString() + "\n");
        System.out.println("迭代：" + subsets3(s).toString() + "\n");

    }

    /**
     * @Method subsets1
     * @Description //TODO 递归
     * 增量构造法
     * 每个元素，都有两种选择，选或者不选。
     * @Author Alan Ruan
     * @Date 2018/12/04 10:41:28
     * @Param [nums]
     * @Return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> subsets1(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        subsets(nums, path, 0 , result);
        return result;
    }

    private static void subsets(int[] nums, List<Integer> path, int step, List<List<Integer>> result){
        if (step == nums.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        //不选nums[step]
        subsets(nums,path,step+1,result);
        //选nums[step]
        path.add(nums[step]);
        subsets(nums,path,step+1,result);
        path.remove(path.size() - 1);

    }


    /**
     * @Method subsets
     * @Description //TODO 位向量法
     * 开一个位向量 bool selected[n] ，每个元素可以选或者不选
     * @Author Alan Ruan
     * @Date 2018/12/04 10:52:04
     * @Param [nums]
     * @Return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> subsets2(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] selected = new boolean[nums.length];
        subsets(nums, selected, 0, result);
        return result;
    }
    private static void subsets(int[] nums, boolean[] selected, int step,
                                List<List<Integer>> result) {
        if (step == nums.length) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (selected[i]) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
            return;
        }
        // 不选S[step]
        selected[step] = false;
        subsets(nums, selected, step + 1, result);
        // 选S[step]
        selected[step] = true;
        subsets(nums, selected, step + 1, result);
    }



    /**
     * @Method subsets
     * @Description //TODO 迭代
     * 增量构造法
     * @Author Alan Ruan
     * @Date 2018/12/04 10:54:55
     * @Param [nums]
     * @Return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> subsets3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // empty subset
        for (int elem : nums) {
            final int n = result.size();
            for (int i = 0; i < n; ++i) { // copy itself
                result.add(new ArrayList<>(result.get(i)));
            }
            for (int i = n; i < result.size(); ++i) {
                result.get(i).add(elem);
            }
        }
        return result;
    }



}

package algorithm.leetcode;

/**
 * Project: SomethingAboutJava
 * Package: algorithm.leetcode
 * Author: Alan Ruan
 * Date: 2019-01-02  11:28
 * Description: //TODO  905. Sort Array By Parity
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity_905 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7};
        int[] result = sortArrayByParity(A);
        for (int a : result){
            System.out.print(a + " ");
        }
    }

    public static int[] sortArrayByParity(int[] A){
        int[] result = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        for (int a : A){
            if (a % 2 != 0){
                result[right] = a;
                right--;
            }else {
                result[left] = a;
                left++;
            }
        }
        return result;
    }
}

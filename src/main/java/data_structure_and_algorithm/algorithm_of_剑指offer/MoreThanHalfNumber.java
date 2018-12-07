package main.java.data_structure_and_algorithm.algorithm_of_剑指offer;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-12-05 10:06
 * Description://TODO 29.数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * 思路：将首次出现的数count+1，与之后的数进行比较，相等则+1，否则—1，最后进行校验是否超过长度的一
 * 半。
 */
public class MoreThanHalfNumber {

    public static void main(String[] args) {

        int[] array = {1,2,2,3,2,1,3,2,2,2};
        System.out.println(moreThanHalfNumSolution(array));

    }

    private static int moreThanHalfNumSolution(int[] array){

        //记录出现最多的数
        int maxCount = array[0];

        int number = array[0];

        int count = 1;

        for (int i = 1; i < array.length; i++){
            if (number != array[i]){
                if (count == 0){
                    number = array[i];
                    count = 1;
                }else {
                    count--;
                }
            }else {
                count++;
            }

            if (count == 1){
                maxCount = number;
            }
        }

        int num = 0;
        for (int j = 0; j < array.length; j++){
            if (array[j] == maxCount){
                num++;
            }
        }

        if (num * 2 > array.length){
            return maxCount;
        }

        return 0;

    }

}

package main.java.data_structure_and_algorithm.algorithm_of_剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-12-05 10:21
 * Description://TODO 30.输入n个整数，找出其中最小的K个数。
 * 思路：先将前K个数放入数组，进行堆排序，若之后的数比它还小，则进行调整
 */
public class GetLeastKNumber {

    public static void main(String[] args) {

        int[] a = {1,2,31,1,2,4,5,131,12,5,4,3};
        System.out.println(getLeastNumberSolution(a,4));

    }

    private static ArrayList<Integer> getLeastNumberSolution(int[] input, int k){

        ArrayList<Integer> list = new ArrayList<>();
        if (input == null | k < 0 | k > input.length){
            return list;
        }

        int[] kArray = Arrays.copyOfRange(input,0,k);

        buildHeap(kArray);

        for (int i = k;i < input.length; i++){
            if (input[i] < kArray[0]){
                kArray[0] = input[i];
                maxHeap(kArray,0);
            }
        }

        for (int i = kArray.length - 1; i >= 0; i--) {
            list.add(kArray[i]);
        }
        return list;

    }


    private static void buildHeap(int[] input){
        for (int i = input.length / 2 - 1 ; i >= 0; i--){
            maxHeap(input,i);
        }
    }

    private static void maxHeap(int[] array, int i){
        int left = 2 * i + 1;
        int right = left + 1;
        int largest = 0;

        if (left < array.length && array[left] > array[i]){
            largest = left;
        }else {
            largest = i;
        }

        if (right < array.length && array[right] > array[largest]){
            largest = right;
        }
        if (largest != i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeap(array, largest);
        }
    }

}

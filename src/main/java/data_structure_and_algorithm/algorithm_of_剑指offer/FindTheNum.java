package main.java.data_structure_and_algorithm.algorithm_of_剑指offer;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-21 10:47
 * Description://TODO  3.在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完
 * 成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 思路：从右上角或左下角开始找，逐行删除，或者用二分法查找
 */
public class FindTheNum {

    public static void main(String[] args){

        int[][] array = new int[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                array[i][j] = i+j+1;
            }
        }
        if (find(array,6)){
            System.out.println("存在");
        }else {
            System.out.println("不存在");
        }

    }



    public static boolean find(int[][] a, int target){

        if (a == null){
            return false;
        }
        int row = 0;
        int column = a[0].length - 1;//从右上角开始找

        while (row < a.length && column > 0){
            if (a[row][column] == target){
                return true;
            }
            if (a[row][column] > target){
                column--;
            }else {
                row++;
            }
        }
        return false;
    }



}

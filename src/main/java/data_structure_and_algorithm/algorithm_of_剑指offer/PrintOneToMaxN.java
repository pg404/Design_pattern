package data_structure_and_algorithm.algorithm_of_剑指offer;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-25 16:17
 * Description://TODO  打印1到最大的n位数
 * 思路：考虑大数问题，使用字符串或数组表示。
 */
public class PrintOneToMaxN {

    public static void main(String [] args){
        printToMaxOfNDigits(3);
    }

    public static void printToMaxOfNDigits(int n) {
        int[] array=new int[n];
        if(n <= 0) {
            return;
        }
        printArray(array, 0);
    }
    private static void printArray(int[] array,int n) {
        for(int i = 0; i < 10; i++) {
            if(n != array.length) {
                array[n] = i;
                printArray(array, n+1);
            } else {
                boolean isFirstNo0 = false;
                for(int j = 0; j < array.length; j++) {
                    if(array[j] != 0) {
                        System.out.print(array[j]);
                        if(!isFirstNo0) {
                            isFirstNo0 = true;
                        }
                    } else {
                        if(isFirstNo0) {
                            System.out.print(array[j]);
                        }
                    }
                }
                System.out.println();
                return ;
            }
        }
    }


}

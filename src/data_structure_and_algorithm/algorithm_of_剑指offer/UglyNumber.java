package data_structure_and_algorithm.algorithm_of_剑指offer;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-26 20:08
 * Description://TODO 34.丑数是只包含因子2、3和5的数，求从小到大的第N个丑数。
 * 思路：乘2或3或5，之后比较取最小值。
 */
public class UglyNumber {

    public static void main(String[] args){

        System.out.println(getUglyNumber(7));

    }

    public static int getUglyNumber(int index){
        if (index <= 0){
            return 0;
        }
        int[] arr = new int[index];
        arr[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        for (int i = 1; i < index; i++){
            int min = Math.min(arr[multiply2] * 2, Math.min(arr[multiply3] * 3, arr[multiply5] * 5));
            arr[i] = min;
            if (arr[multiply2] * 2 == min ){
                multiply2++;
            }
            if (arr[multiply3] * 3 == min){
                multiply3++;
            }
            if (arr[multiply5] * 5 == min){
                multiply5++;
            }
        }
        return arr[index-1];

    }

}

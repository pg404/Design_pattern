package data_structure_and_algorithm.algorithm_of_剑指offer;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-12-08 17:07
 * Description://TODO 46.求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?
 * B:C）。
 */
public class SumWithoutChengChu {

    public static void main(String[] args) {

        System.out.println(sum(10));

    }

    private static int sum(int n){
        int sum = n;
        boolean result = (n > 0 )&& ((sum += sum(n-1)) > 0);
        return sum;
    }
}

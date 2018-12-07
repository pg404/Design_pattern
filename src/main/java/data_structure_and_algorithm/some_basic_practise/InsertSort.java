package main.java.data_structure_and_algorithm.some_basic_practise;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm
 * Author:Alan Ruan
 * Date:2018-11-20 09:26
 * Description://TODO 直接插入排序   每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止
 */
public class InsertSort {

    public static void main(String[] args){

        int[] a = {3,1,5,7,2,4,9,6,10,8};
        System.out.println("排序前: ");
        print(a);
        insertSort(a);
        System.out.println("直接插入排序后：");
        print(a);

    }

    public static void print(int[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }


    public static void insertSort(int[] a){
        //把头部第一个当作已经排好的了，把后面的一个个插入到已经排序好的列表中来
        for (int i = 1; i < a.length; i++){
            int j;
            //x相当于待插入的数
            int x = a[i];
            //假如x比前面的值小，则将前面的值后移
            for ( j = i; j > 0 && x < a[j-1]; j--){
                a[j] = a[j-1];
            }
//            System.out.println("此时j的值为："+j);  //注意for循环的终止条件，
            a[j] = x;
        }

    }

}

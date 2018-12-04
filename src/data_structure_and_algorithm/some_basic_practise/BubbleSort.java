package data_structure_and_algorithm.some_basic_practise;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm
 * Author:Alan Ruan
 * Date:2018-11-20 10:51
 * Description://TODO
 */
public class BubbleSort {

    public static void main(String[] args){

        int[] a = {3,1,5,7,2,4,9,6,10,8};
        System.out.println("排序前: ");
        print(a);
        bubbleSort(a);
        System.out.println("冒泡排序后：");
        print(a);


    }


    public static void print(int[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }

    public static void bubbleSort(int[] numbers)
    {
        int temp = 0;
        int size = numbers.length;
        for(int i = 0 ; i < size-1; i ++)
        {
            for(int j = 0 ;j < size-1-i ; j++)
            {
                if(numbers[j] > numbers[j+1])  //交换两数位置
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;

                }
            }
        }
    }

}

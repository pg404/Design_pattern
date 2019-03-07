package algorithm.some_basic_practise;

/**
 * Project:Exercise
 * Package:main.java.algorithm
 * Author:Alan Ruan
 * Date:2018-11-19 12:55
 * Description://TODO
 */
public class ArrayExpand {

    public static void main(String[] args){

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++){
            arr[i] = i;
        }

        System.out.println("当前数组的长度为" + arr.length);
        for (int i = 0 ; i< arr.length; i++){
            System.out.println(arr[i]);
        }

        int[] newArr = new int[arr.length*2];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }

        arr = newArr;

        System.out.println("改变后数组长度为："+ arr.length);
        for (int i = 0; i < arr.length;i++){
            System.out.println(arr[i]);
        }

    }

}
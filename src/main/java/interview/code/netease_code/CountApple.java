package interview.code.netease_code;

import java.util.Scanner;

/**
 * Project:Exercise
 * Package:main.java.interview.code.interview
 * Author:Alan Ruan
 * Date:2018-08-14 15:48
 * Description://TODO 网易java笔试编程第二题
 * 题目描述
 * 又到了丰收的季节，恰好小易去牛牛的果园里游玩。 牛牛常说他多整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。 在果园里有N堆苹果，每堆苹果的数量为ai,小易希望知道从左往右数第x个苹果是属于哪一堆的。 牛牛觉得问题太简单了，所以希望你来替他回答。
 *
 * 输入描述
 * 第一行 一个数 n (1<= n <= $10^5$)
 * 第二行 n个数 $a{i}$ (1<=$a{i}$<=1000),表示从左往右数第i堆有多少苹果
 * 第三行 一个数m (1<= m <= $10^5$),表示有m次询问
 * 第四行 m个数$q{i}$, 表示小易希望知道第$q{i}$个苹果属于哪一堆。
 *
 * 输出描述
 * m行，第i行输出第$q_{i}$个苹果属于哪一堆。
 *
 * 示例
 * 输入
 * 5
 * 2 7 3 4 9
 * 3
 * 1 25 11
 * 输出
 *
 * 1
 * 5
 * 3
 */
public class CountApple {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入苹果的堆数：");
        int n = scanner.nextInt();

        int[] appleNum = new int[n];
        for (int i = 0; i < n ;i++){
            int j = i+1;
            System.out.println("输入第"+ j + "堆苹果的数量：");
            appleNum[i] = scanner.nextInt();
        }

        System.out.println("输入要查询的次数：");
        int m = scanner.nextInt();

        int[] query = new int[m];
        for (int j = 0; j < m; j++){
            int i = j+1;
            System.out.println("输入第" + i +"次查询的数目：");
            query[j] = scanner.nextInt();
        }

        //左边累加
        int[] leftsum = new int[n];
        int sum = 0;
        for (int i = 0; i < n ; i++){
            sum += appleNum[i];
            leftsum[i] = sum;
        }

        //计算每一个query
        for (int i = 0; i < m; i++){
            int j = i + 1;
            System.out.print("第" + j +"次查询的数目位于第");
            System.out.print(binSearch(leftsum,query[i]) + 1);
            System.out.println("堆");
        }
    }

    public static int binSearch(int[] arr, int k){
        int mid = arr.length/2;
        if (arr[mid] == k){
            return mid;
        }
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            mid = (end - start) / 2 + start;
            if (k < arr[mid]){
                end = mid-1;
            }else if (k > arr[mid]){
                start = mid +1;
            }else {
                return mid;
            }
        }
        return start;
    }

}

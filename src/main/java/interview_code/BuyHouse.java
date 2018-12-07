package main.java.interview_code;

import java.util.Scanner;

/**
 * Project:Exercise
 * Package:main.java.interview_code.code.interview
 * Author:Alan Ruan
 * Date:2018-09-08 16:16
 * Description://TODO  网易校招java笔试  买房
 */
public class BuyHouse {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int m,n,k;
        int min = 0;
        int max ;

        m = scanner.nextInt();

        int[][] a = new int[m][2];

        for (int i = 0; i < m; i++){
            for (int j = 0; j <2; j++){
                a[i][j] = scanner.nextInt();
            }
        }


        for (int i = 0;i <m;i++){
            n = a[i][0];
            k = a[i][1];

            if (n == 0 || n ==1 || n == k || k == 0 || k == 1){
                max = 0;
            }else if(n - k == 1 || k ==2){
                max = 1;
            }else {
                max = Math.min(n - k, k - 1);
            }

            System.out.print(min);
            System.out.print(" ");
            System.out.println(max);
        }


    }
}

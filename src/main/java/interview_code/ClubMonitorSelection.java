package main.java.interview_code;

import java.util.Scanner;

/**
 * Project:Exercise
 * Package:main.java.interview_code.code.interview
 * Author:Alan Ruan
 * Date:2018-09-08 15:39
 * Description://TODO  网易校招java笔试  社团主席选举
 */
public class ClubMonitorSelection {

    public static void main(String[] args){

        int m, n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < 2; j++){
                a[i][j] = scanner.nextInt();
            }
        }

        int count = 0;
        int[] b = new int[m+1];

        for (int i = 0; i < n; i++){
            if (a[i][0] == 1){
                count++;
            }
        }

        int max = 0;

        if (count > n/2){
            System.out.println(0);
        }else {
            for (int i = 0; i < n; i++){
                b[a[i][0]]++;//统计每个候选人的票数
            }
            for (int i = 0; i < m; i++){
                if (b[i] > max){
                    max = b[i];   //最多的有几票
                }
            }

            int min = max - b[1] + 1;//最少要收买几个人

            int[] c = new int[n];

            for (int i = 0; i <n; i++){
                c[i] = a[i][1];
            }

            for (int i = 0; i < n; i++){
                for (int j = n-1; j > 0; j--){
                    if (c[j] < c[j-1]){
                        int temp = c[j];
                        c[j] = c[j-1];
                        c[j-1] = temp;
                    }
                }
            }

            int total = 0;
            for (int i = 0; i < min; i++){
                total = total + c[i];
            }

            System.out.println(total);
        }




    }


}

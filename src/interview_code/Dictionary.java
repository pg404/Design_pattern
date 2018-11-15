package interview_code;

import java.util.Scanner;

/**
 * Project:Exercise
 * Package:interview_code.code.interview
 * Author:Alan Ruan
 * Date:2018-08-14 17:34
 * Description://TODO 网易java笔试编程第三题
 * 题目三
 * 题目描述
 * 给你n个a,m个z组成所有可能的字符串，并将字符串按字典序从小到大排列，输出第k个字符串。
 * 若不存在，输出-1。
 *
 * 输入描述
 * 第一行为三个数，分别为a的个数n,z的个数m,第k个字符串。
 *
 * 输出描述
 * 第k个字符串
 *
 * 示例
 * 输入
 *
 * 2 2 6
 * 输出
 *
 * zzaa
 */
public class Dictionary {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;

        for (int i = 1;i <= n; i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++){
            dp[0][i] = 1;
        }

        for(int i = 1; i <= n ; i++){
            for (int j = 1; j <= m; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        if (k > dp[n][m]){
            System.out.println(-1);
        }else {

        }

        /*
        if (k > dp[n][m]) {
            System.out.println(-1);
        } else {
            int n1 = n;
            int m1 = m;
            for (int i = 0; i < n+m; i++) {
                if (n1 > 0 && k <= dp[n1-1][m1]) {
                    sb.append("a");
                    n1--;
                } else {
                    if (n1 > 0) {
                        k -= dp[n1-1][m1];
                    }
                    sb.append("z");
                    m1--;
                }
            }
            System.out.println(sb.toString());
        }
        */

    }
}

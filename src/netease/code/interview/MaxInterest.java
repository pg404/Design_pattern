package netease.code.interview;

import java.util.Scanner;

/**
 * Project:Exercise
 * Package:PACKAGE_NAME
 * Author:Alan Ruan
 * Date:2018-08-11 15:48
 * Description://TODO 网易java笔试编程第一题
 *
 * 题目一
 * 题目描述
 * 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望老师讲到有趣的地方的时候叫醒他一下。你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
 *
 * 输入描述
 * 第一行n，k, (1 <= n, k <= $10^5$)，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 * 第二行 n个数，$a{1},a{2},..., a{n} (1<= a{i} <= 10^4)$，表示小易对每分钟知识点的感兴趣评分。
 * 第三行 n个数，$t{1}, t{2}, ..., t_{n}$，表示每分钟小易是否清醒，1表示清醒。
 *
 * 输出描述
 * 小易这堂课听到的知识点的最大兴趣值。
 *
 * 示例
 * 输入
 * 6 3
 * 1 3 5 2 5 4
 * 1 1 0 1 0 0
 * 输出
 *
 * 16
 */
public class MaxInterest{

    public MaxInterest(){};

    public double countInterest(){

        int classMinutes;//课程总时间
        int wakeupMinutes;//叫醒一次能清醒的时间

        //最大收益
        int maxInterest = 0;

        Scanner scanner = new Scanner(System.in);

        classMinutes = scanner.nextInt();
        wakeupMinutes = scanner.nextInt();

        //兴趣点每分钟分布
        int[] interestpoints = new int[classMinutes];
        for (int i = 0; i < classMinutes; i++){
            interestpoints[i] = scanner.nextInt();
        }

        //每分钟是否睡着
        int[] wakeuptime = new int[classMinutes];
        for (int j = 0; j < classMinutes; j++){
            wakeuptime[j] = scanner.nextInt();
            if (wakeuptime[j] > 0){
                //没睡着的时间，全都算到收益去。
                maxInterest = maxInterest + interestpoints[j];
            }
        }

        int max = -1;
        for(int i = 0; i < classMinutes; i++){
            if (wakeuptime[i] == 0){
                int temp = maxInterest;
                for (int j = i; j < Math.min(classMinutes, i + wakeupMinutes); j++){
                    if (wakeuptime[j] == 0){
                        temp += interestpoints[j];
                    }
                }
                if (temp > max){
                    max = temp;
                }
            }
        }

        return max;
    }

    public static void main(String[] args){
        MaxInterest m = new MaxInterest();
        System.out.println(m.countInterest());
    }

}

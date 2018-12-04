package data_structure_and_algorithm.essential_algorithm_of_leetcode.数论;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm.essential_algorithm_of_leetcode.数论
 * Author:Alan Ruan
 * Date:2018-12-03 18:53
 * Description://TODO Happy Number
 * 描述
 * Write a function to determine if a number is "happy number".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace
 * the number by the sum of the squares of its digits, and repeat the process until the number equals 1
 * (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this
 * process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 1 + 9 = 82
 * 8 + 2 = 68
 * 6 + 8 = 100
 * 1 + 0 + 0 = 1
 * 分析
 * 这题找到规律后就简单了。如果右边的出现了某个重复的数，但不是1，说明会无限循环下去，这个数就不
 * 是快乐数，如果是1，则是快乐数。
 */
public class HappyNumber {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int x = scanner.nextInt();
        if (isHappyNumber(x)){
            System.out.println("\n这个数是happy number");
        }else {
            System.out.println("\n不是happy number");
        }
    }

    public static boolean isHappyNumber(int n){
        final Set<Integer> existed = new HashSet<>();
        while (true){
            int sum = 0;
            while (n > 0){
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (existed.contains(sum)){
                return sum == 1;
            }else {
                existed.add(sum);
                n = sum;
            }
        }
    }

}

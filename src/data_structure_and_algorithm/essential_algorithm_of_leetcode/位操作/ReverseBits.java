package data_structure_and_algorithm.essential_algorithm_of_leetcode.位操作;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm.essential_algorithm_of_leetcode.位操作
 * Author:Alan Ruan
 * Date:2018-12-04 09:55
 * Description://TODO  Reverse Bits
 * 描述
 * Reverse bits of a given 32 bits unsigned integer
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100 ),
 * return 964176192 (represented in binary as 00111001011110000010100101000000 ).
 * Follow up: If this function is called many times, how would you optimize it?
 * 分析
 * 最简单直接的做法，从右向左把一位位取出来，添加到新生成的整数的最低位即可。
 * 第二个简单的方法，左右不断交换位，直到相遇。
 */
public class ReverseBits {

    public static void main(String[] args) {

        int x = 43261596 ;
        System.out.println(reverseBits1(x));
        System.out.println(reverseBits2(x));

    }

    /**
     * @Method reverseBits1
     * @Description //TODO 从右向左把一位位取出来，添加到新生成的整数的最低位即可
     * @Author Alan Ruan
     * @Date 2018/12/04 10:22:28
     * @Param [n]
     * @Return int
     */
    public static int reverseBits1(int n){
        int result = 0;
        for (int i = 0; i < 32; ++i){
            if ((n & 1) == 1){ //证明最低位为1
                result = (result << 1) + 1; //左移一位再加1
            }else {
                result = result << 1;
            }
            n = n >> 1;
        }
        return result;
    }


    /**
     * @Method reverseBits2
     * @Description //TODO  左右不断交换位，直到相遇
     * @Author Alan Ruan
     * @Date 2018/12/04 10:22:44
     * @Param [n]
     * @Return int
     */
    public static int reverseBits2(int n){
        int left = 0;
        int right = 31;
        while (left < right){
            int x = (n >> left) & 1;
            int y = (n >> right) & 1;

            if (x != y){
                n ^= (1 << left) | (1 << right); //异或运算
            }
            ++left;
            --right;
        }
        return n;
    }

}

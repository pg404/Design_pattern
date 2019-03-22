package interview.code;

/**
 * Project: SomethingAboutJava
 * Package: interview
 * Author: Alan Ruan
 * Date: 2019-03-03  20:50
 * Description: //TODO vivo春招笔试代码第一道
 *
 * 不同字符串的全排列，仅限26位小写字母
 *
 * 思路：从字符串数组中每次选取一个元素，作为结果中的第一个元素。
 * 然后，对剩余的元素全排列，步骤跟上面一样。很明显这是个递归处理的过程，一直到最后即可
 *
 */
public class StringFullArrangement {


    public static void swap(char[] str, int i , int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void permutation(char[] s, int from , int to){
        if (to <= 1){
            return;
        }
        if (from == to){
            System.out.println(s);
        }else {
            for (int i = from;  i <= to; i++){
                swap(s, i, from);//交换前缀，使之产生下一个前缀
                permutation(s, from+1, to);
                swap(s, from, i);//将前缀换回，继续做上一个前缀的排列
            }
        }
    }

    public static void main(String[] args) {

        char[] s = {'a', 'b', 'c', 'd'};
        permutation(s, 0, 3);

    }



}

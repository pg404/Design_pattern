package interview_code;

import java.util.Scanner;
import java.util.Stack;

/**
 * Project:Exercise
 * Package:interview_code
 * Author:Alan Ruan
 * Date:2018-11-21 20:33
 * Description://TODO  招商银行 网络科技部 一轮视频面试手撕代码题目
 *
 * 输入为只包含'(', ')', '{', '}', '[' 和']'这六个括号字符的字符串。判断输入字符串中的括号是否符合代数算式规则。例如, "()"、"({})" 和 "()[]" 是合法的括号。而 "(]" 和 "([)]" 不是。
 * 输入描述:
 * 输入包含一行:
 *  包括一个只含'(',')','{','}','[',']'的字符串,长度小于等于50
 *
 * 输出描述:
 * 合法输出true，否则输出false。
 *
 *
 */
public class BracketsMatch {


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            System.out.println(bracketsmatch(s));
        }
    }

    private static boolean bracketsmatch(String s){

        Stack<Character> stack = new Stack<Character>();
        boolean flag = true;
        char[] chs = s.toCharArray();
        Character c;
        for (char ch : chs){
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else {
                if (stack.isEmpty()){
                    flag = false;
                    break;
                }else {
                    c = stack.peek();
                    if (isMatch(c, ch)){
                        stack.pop();
                    }else {
                        flag = false;
                        break;
                    }
                }
            }
        }
        if(stack.size() != 0){
            flag = false;
        }
        return flag;
    }


    private static boolean isMatch(Character ch, char c){
        if (ch == '(' && c == ')'){
            return true;
        }
        if (ch == '{' && c == '}'){
            return true;
        }
        if (ch == '[' && c == ']'){
            return true;
        }
        return false;
    }

}

package data_structure_and_algorithm.some_basic_practise;

import java.util.Scanner;
import java.util.Stack;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm
 * Author:Alan Ruan
 * Date:2018-11-19 14:09
 * Description://TODO
 */

public class PrintTree {

    /**
     * 计算后缀表达式的值
     * @param exp
     * @return
     */
    public static int giveResult(String exp){
        Stack<Integer> stack = new Stack<Integer>();
        int length = exp.length();
        int index = 0;
        while(index < length){
            switch(exp.charAt(index)){
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    //减去相应的ASCII码获得该数字
                    stack.push((int) exp.charAt(index) - 48);
                    break;
                case '+':
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a + b);
                    break;
                case '-':
                    int c = stack.pop();
                    int d = stack.pop();
                    stack.push(d - c);
                    break;
                case '*':
                    int e = stack.pop();
                    int f = stack.pop();
                    stack.push(e * f);
                    break;
                case '/':
                    int g = stack.pop();
                    int h = stack.pop();
                    stack.push(h / g);
                    break;

                    default:break;
            }
            index++;
        }
        return stack.pop();
    }

    /**
     * 中缀转后缀
     * @param exp
     */
    public static String infixToPostfix(String exp){

        System.out.println("原中缀表达式是：" + exp);

        Stack<Character> stack = new Stack<Character>();
        String suffix = "";
        int index = 0;
        int length = exp.length();
        while(index < length){
            switch(exp.charAt(index)){
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    suffix += exp.charAt(index);
                    break;
                case '*':
                case '/':
                    stack.push(exp.charAt(index));
                    break;
                case '(':
                    stack.push(exp.charAt(index));
                    break;

                case '+':
                case '-':
                    while (stack.size() != 0) {
                        char temp = stack.pop();
                        if (temp == '(') {
                            stack.push('(');
                            break;
                        }
                        suffix += temp;
                    }
                    stack.push(exp.charAt(index));
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '('){
                        suffix += stack.pop();
                    }
                    stack.pop();
                    break;

                    default:
                        break;

            }
            index++;
        }
        while(!stack.isEmpty()){
            suffix += stack.pop();
        }
        System.out.println("转换为后缀表达式为：" + suffix);

        return suffix;
    }

    public static void main(String[] args) {

        System.out.println("请输入一个中缀表达式：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int result = giveResult(infixToPostfix(str));
        System.out.println("最终结果为：" + result);
    }

}

//注意
//stack的pop方法跟peek方法一样都是返回栈顶的值，但是peek并不把栈顶的值移除



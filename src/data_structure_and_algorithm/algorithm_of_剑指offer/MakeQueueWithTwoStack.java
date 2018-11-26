package data_structure_and_algorithm.algorithm_of_剑指offer;

import java.util.Stack;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-23 16:21
 * Description://TODO 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * ：一个栈压入元素，而另一个栈作为缓冲，将栈1的元素出栈后压入栈2中
 */
public class MakeQueueWithTwoStack {

    public static void main(String[] args){

        //入队： 0、1、2、3、4、5、6、7、8、9
        for (int i = 0; i < 10; i++){
            MakeQueueWithTwoStack.enQueue(i);
        }
        //出队：
        try {
            for (int i = 10; i > 0; i--){
                System.out.println(MakeQueueWithTwoStack.deQueue());
            }
        }catch (Exception e){
        }
    }


    public  static Stack stack1 = new Stack();
    public static Stack stack2 = new Stack();
    int data;

    public  static void mypush(int node) {
        stack1.push(node);
    }
    public static int mypop() throws Exception {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("栈为空！");
        }
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push((int)stack1.pop());
            }
        }
        return (int)stack2.pop();
    }

    //实现入队
    public static void enQueue(int i){
        mypush(i);
    }

    //实现出队
    public static int deQueue() throws Exception{
        return mypop();
    }


}

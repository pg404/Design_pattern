package data_structure.LinkedList;


import org.junit.Test;

import java.util.Stack;


/**
 * Project: SomethingAboutJava
 * Package: data_structure.LinkedList
 * Author: Alan Ruan
 * Date: 2019-03-08  17:06
 * Description: //TODO 1、从尾到头打印单向链表
 * 对于这种颠倒顺序打印的问题，我们应该就会想到栈，后进先出。因此这一题要么自己新建一个栈，
 * 要么使用系统的栈（系统递归调用方法时的栈）。需要把链表遍历完一次，所以它的时间复杂度为 O(n)
 * 注意：不能先把链表反转，再遍历输出，因为这样做会破坏链表节点原来的顺序
 *
 */
public class QuestionOneDemo {

    public void reversePrint(LinkedNode head){
        if (head == null){
            return;
        }

        Stack<LinkedNode> stack = new Stack<>();
        LinkedNode tempNode = head;

        while (tempNode.getNext() != null){
            stack.push(tempNode);
            tempNode = tempNode.next;
             //  这里的顺序
        }

        while (stack.size() > 0){
            LinkedNode node = stack.pop();
            System.out.println(node.getElement());
        }

    }


    /**
     * @Method: reversePrint2
     * @Param: [head]
     * @Return void
     * @Author: Alan Ruan
     * @Date: 2019/04/01 15:50:45
     * @Description: //TODO  使用系统的栈（递归）
     */
    public void reversePrint2(LinkedNode head){
        if (head == null){
            return;
        }

        reversePrint2(head.next);
        System.out.println(head.getElement());
    }



   @Test
    public void test(){
        MyLinkedList myLinkedList = new MyLinkedList();

        LinkedNode newNode1 = new LinkedNode("欧阳锋", null);
        LinkedNode newNode2 = new LinkedNode("黄药师", null);
        LinkedNode newNode3 = new LinkedNode("洪七公", null);

        myLinkedList.insert(newNode1, 1);
        myLinkedList.insert(newNode2, 2);
        myLinkedList.insert(newNode3, 3);

       System.out.println("原始序列为：");
       myLinkedList.showAll();


    }

}

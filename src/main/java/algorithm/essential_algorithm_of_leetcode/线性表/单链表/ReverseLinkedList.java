package algorithm.essential_algorithm_of_leetcode.线性表.单链表;

import algorithm.some_basic_practise.ListNode;

/**
 * Project:Exercise
 * Package:main.java.algorithm.essential_algorithm_of_leetcode.线性表.单链表
 * Author:Alan Ruan
 * Date:2018-12-03 13:10
 * Description://TODO Reverse Linked List
 * 描述
 * Reverse a singly linked list.
 *
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode E = new ListNode(5,null);
        ListNode D = new ListNode(4,E);
        ListNode C = new ListNode(3,D);
        ListNode B = new ListNode(2,C);
        ListNode A = new ListNode(1,B);

        System.out.println("逆置链表前链表为：");
        ListNode temp = A;
        print(temp);

        System.out.println("\n采用迭代法逆置链表：");
        ListNode temp1 = DieDai(A);
        print(temp1);

        System.out.println("\n采用递归法逆置链表：");
        ListNode temp2 = DiGui(temp1);
        print(temp2);
    }

    private static void print(ListNode temp){
        while (temp != null){
            System.out.print(temp.getVal());
            temp = temp.getNextNode();
        }
    }

    /**
     * @Method DieDai
     * @Description //TODO 迭代法   用三个指针 tail , p , q ，紧紧相邻，不断前进，每次将 p.next 指向 tail ，将 q.next 指向 p
     * Time Complexity: O(n), Space Complexity: O(1)
     * @Author Alan Ruan
     * @Date 2018/12/03 13:16:23
     * @Param [head]
     * @Return main.java.algorithm.some_basic_practise.ListNode
     */
    public static ListNode DieDai(ListNode head){
        if (head == null || head.getNextNode() == null){
            return head;
        }

        ListNode tail = null;
        ListNode p = head;
        ListNode q = p.getNextNode();

        while (q != null){
            ListNode old = q.getNextNode();
            p.setNextNode(tail);
            q.setNextNode(p);

            tail = p;
            p = q;
            q = old;
        }
        return p;
    }


    /**
     * @Method DiGui
     * @Description //TODO 递归法
     * Time Complexity: O(n), Space Complexity: O(n)
     * @Author Alan Ruan
     * @Date 2018/12/03 13:20:16
     * @Param [head]
     * @Return main.java.algorithm.some_basic_practise.ListNode
     */
    public static ListNode DiGui(ListNode head){

        if (head == null || head.getNextNode() == null){
             return head;
        }

        ListNode tail = head.getNextNode();
        head.setNextNode(null);

        ListNode newHead = DiGui(tail);
        tail.setNextNode(head);

        return newHead;
    }

}

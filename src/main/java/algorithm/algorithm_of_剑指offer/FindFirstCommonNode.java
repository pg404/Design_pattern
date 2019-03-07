package algorithm.algorithm_of_剑指offer;

import algorithm.some_basic_practise.ListNode;

/**
 * Project:Exercise
 * Package:main.java.algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-12-05 11:03
 * Description://TODO 37.输入两个链表，找出它们的第一个公共结点
 */
public class FindFirstCommonNode {

    public static void main(String[] args) {

        ListNode c = new ListNode(3,null);
        ListNode b = new ListNode(2,c);
        ListNode a = new ListNode(1,b);

        ListNode C = new ListNode(2,null);
        ListNode B = new ListNode(1,C);
        ListNode A = new ListNode(3,B);

        ListNode node = findFirstCommonNodeSolution(a,A);

        System.out.println(node.getVal());

    }

    private static ListNode findFirstCommonNodeSolution(ListNode pHead1, ListNode pHead2){

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2){
            p1 = (p1 != null ? p1.getNextNode() : pHead2);
            p2 = (p2 != null ? p2.getNextNode() : pHead1);
        }

        return p1;

    }

}

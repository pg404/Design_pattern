package data_structure_and_algorithm.algorithm_of_剑指offer;

import data_structure_and_algorithm.some_basic_practise.ListNode;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-26 14:53
 * Description://TODO 17.输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 思路：递归与非递归求解，小数放在前面。
 */
public class MergeTwoList {

    public static void main(String[] args){

        ListNode C = new ListNode(6,null);
        ListNode B = new ListNode(4, C);
        ListNode A = new ListNode(2, B);

        ListNode c = new ListNode(5,null);
        ListNode b = new ListNode(3,c);
        ListNode a = new ListNode(1,b);

        ListNode node = merge(a,A);
        while (node != null){
            System.out.println(node.getVal());
            node = node.getNextNode();
        }

    }


    public static ListNode merge(ListNode listNode1, ListNode listNode2){

        if (listNode1 == null){
            return listNode2;
        }
        if (listNode2 == null){
            return listNode1;
        }

        ListNode newHead = null;
        if (listNode1.getVal() <= listNode2.getVal()){
            newHead = listNode1;
            newHead.setNextNode(merge(listNode1.getNextNode(), listNode2));
        }else {
            newHead = listNode2;
            newHead.setNextNode(merge(listNode1,listNode2.getNextNode()));
        }
        return newHead;

    }

}

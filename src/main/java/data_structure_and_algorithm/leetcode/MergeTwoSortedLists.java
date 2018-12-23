package data_structure_and_algorithm.leetcode;

import data_structure_and_algorithm.some_basic_practise.ListNode;

/**
 * Project: SomethingAboutJava
 * Package: data_structure_and_algorithm.leetcode
 * Author: Alan Ruan
 * Date: 2018-12-19  14:38
 * Description: //TODO  Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode A = new ListNode(5,null);
        ListNode B = new ListNode(3, A);
        ListNode C = new ListNode(1,B);

        ListNode a = new ListNode(6,null);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(2, b);

        ListNode temp = mergeTwoSortedLists(c, C);

        while (temp != null){
            System.out.println(temp.getVal() + " ");
            temp = temp.getNextNode();
        }

    }

    private static ListNode mergeTwoSortedLists(ListNode listNode1, ListNode listNode2){

        if (listNode1 == null){
            return listNode2;
        }
        if (listNode2 == null){
            return listNode1;
        }
        if (listNode1.getVal() < listNode2.getVal()){
            listNode1.setNextNode(mergeTwoSortedLists(listNode1.getNextNode(), listNode2));
            return listNode1;
        }else {
            listNode2.setNextNode(mergeTwoSortedLists(listNode1, listNode2.getNextNode()));
            return listNode2;
        }

    }


}

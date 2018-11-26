package data_structure_and_algorithm.algorithm_of_剑指offer;

import data_structure_and_algorithm.ListNode;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-26 11:34
 * Description://TODO  13.O(1)时间删除链表节点
 * 思路：将要删除节点的下一个节点的值赋给要删除的节点，然后指向下下一个节点
 */
public class DeleteNodeInO1 {

    public static void main(String[] args){
        ListNode d = new ListNode(4, null);
        ListNode c = new ListNode(3,d);
        ListNode b = new ListNode(2,c);
        ListNode a = new ListNode(1, b);

        ListNode temp = a;
        while (temp != null){
            System.out.print(temp.getVal() + " ");
            temp = temp.getNextNode();
        }

        System.out.println();
        deleteNode(a, d);

        while (a != null){
            System.out.print(a.getVal() + " ");
            a = a.getNextNode();
        }

    }

    public static void deleteNode(ListNode head, ListNode delistnode){

        if (delistnode == null || head == null){
            return;
        }
        //如果删除的节点是头节点
        if (head == delistnode){
            head = null;
        }else {
            //如果删除的节点是最后一个, 把倒数第二个节点指向空
            if (delistnode.getNextNode() == null){
                ListNode temp = head;
                while (temp.getNextNode().getNextNode() != null){
                    temp = temp.getNextNode();
                }
                temp.setNextNode(null);

            }else {
                delistnode.setVal(delistnode.getNextNode().getVal());
                delistnode.setNextNode(delistnode.getNextNode().getNextNode());
            }
        }

    }

}

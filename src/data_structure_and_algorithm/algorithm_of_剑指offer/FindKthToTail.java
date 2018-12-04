package data_structure_and_algorithm.algorithm_of_剑指offer;

import data_structure_and_algorithm.some_basic_practise.ListNode;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-26 12:10
 * Description://TODO 输入一个链表，输出该链表中倒数第k个结点
 * 思路：定义一快一慢两个指针，快指针走K步，然后慢指针开始走，快指针到尾时，慢指针就找到了倒数第K个
 * 节点。
 *
 *
 * 扩展题：找中间节点，使用两个指针，一个走一步，一个走两步。找到中间节点
 *
 */
public class FindKthToTail {

    public static void main(String[] args){

        ListNode e = new ListNode(5,null);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3,d);
        ListNode b = new ListNode(2,c);
        ListNode a = new ListNode(1, b);

        System.out.println(findLastK(a,3).getVal());


    }

    public static ListNode findLastK(ListNode head, int k){
        if (head == null || k <= 0){
            return  null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (k-- > 1){
            if (fast.getNextNode() != null){
                fast = fast.getNextNode();
            }else {
                return null;
            }

        }
        while (fast.getNextNode() != null){
            fast = fast.getNextNode();
            slow = slow.getNextNode();
        }
        return slow;

    }

}

package interview.code.vivo_code;

/**
 * Project: SomethingAboutJava
 * Package: interview
 * Author: Alan Ruan
 * Date: 2019-03-03  20:08
 * Description: //TODO vivo春招笔试代码第二道
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */
class ListNode {
    int data;
    ListNode next;
    ListNode(int x){
        this.data = x;
        this.next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data+
                '}';
    }
}
public class LinkedListCircle {



    public static ListNode detectCircle(ListNode head){
        if (head == null || head.next == null){
            return null;//不存在圈
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){ //此处便是圈的入口点
                while (head != fast){
                    head = head.next;
                    fast = fast.next;
                }
                return head;
            }
        }

        return null;

    }

    public static void main(String[] args) {

        ListNode a =  new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next= c;
        c.next = d;
        d.next = e;
        e.next = c;

        ListNode test = detectCircle(a);
        System.out.println(test.toString());

    }

}

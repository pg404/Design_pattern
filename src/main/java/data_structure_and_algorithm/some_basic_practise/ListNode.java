package data_structure_and_algorithm.some_basic_practise;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm
 * Author:Alan Ruan
 * Date:2018-11-26 11:38
 * Description://TODO
 */
public class ListNode {

    private int val;
    private ListNode nextNode;

    public ListNode(int val, ListNode listNode){
        this.val=val;
        this.nextNode=listNode;
    }



    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }
}

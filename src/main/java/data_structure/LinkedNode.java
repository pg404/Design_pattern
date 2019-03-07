package data_structure;

/**
 * Project: SomethingAboutJava
 * Package: data_structure
 * Author: Alan Ruan
 * Date: 2019-03-07  12:55
 * Description: //TODO  链表的节点类
 */
public class LinkedNode {

    Object element;
    LinkedNode next;

    public LinkedNode(Object element, LinkedNode next){
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}

package data_structure.HuffmanTree;

/**
 * Project: SomethingAboutJava
 * Package: data_structure
 * Author: Alan Ruan
 * Date: 2019-03-05  20:52
 * Description: //TODO 树的节点类
 */
public class Node implements Comparable{

    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(Object o) {
        Node that = (Node) o;
        double result = this.value - that.value;
        return result > 0 ? 1 : result == 0 ? 0 : -1;
    }
}

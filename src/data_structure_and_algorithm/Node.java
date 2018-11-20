package data_structure_and_algorithm;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm
 * Author:Alan Ruan
 * Date:2018-11-19 17:11
 * Description://TODO
 */
public class Node {//二叉树节点

    private int data;
    private Node leftNode;
    private Node rightNode;

    public Node(int data, Node leftNode, Node rightNode){
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }

    public Node getLeftNode(){
        return leftNode;
    }

    public void setLeftNode(Node leftNode){
        this.leftNode = leftNode;
    }

    public Node getRightNode(){
        return rightNode;
    }

    public void setRightNode(Node rightNode){
        this.rightNode = rightNode;
    }

}


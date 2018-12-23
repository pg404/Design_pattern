package data_structure_and_algorithm.some_basic_practise;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm
 * Author:Alan Ruan
 * Date:2018-11-19 17:11
 * Description://TODO
 */
public class TreeNode {//二叉树节点

    private int data;
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;

    public TreeNode(int data, TreeNode leftTreeNode, TreeNode rightTreeNode){
        this.data = data;
        this.leftTreeNode = leftTreeNode;
        this.rightTreeNode = rightTreeNode;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }

    public TreeNode getLeftTreeNode(){
        return leftTreeNode;
    }

    public void setLeftTreeNode(TreeNode leftTreeNode){
        this.leftTreeNode = leftTreeNode;
    }

    public TreeNode getRightTreeNode(){
        return rightTreeNode;
    }

    public void setRightTreeNode(TreeNode rightTreeNode){
        this.rightTreeNode = rightTreeNode;
    }

}


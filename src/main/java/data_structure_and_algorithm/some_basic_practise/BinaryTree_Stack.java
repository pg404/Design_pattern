package main.java.data_structure_and_algorithm.some_basic_practise;

import java.util.Stack;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm
 * Author:Alan Ruan
 * Date:2018-11-19 18:32
 * Description://TODO 通过栈实现二叉树的先序中序后序三种遍历（非递归）
 *
 */
public class BinaryTree_Stack {


    public static TreeNode init(){

        return BinaryTree_DiGui.init();


    }

    //打印节点数值
    public static void printNode(TreeNode treeNode){
        System.out.print(treeNode.getData());
    }


    //先序遍历 【根、左、右】
    public static void preOrder_stack(TreeNode root){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;


        while(treeNode != null || stack.size()>0){
            //将所有左孩子压栈
            if(treeNode != null){
                //压栈之前先访问
                printNode(treeNode);
                stack.push(treeNode);
                treeNode = treeNode.getLeftTreeNode();

            }else{
                //节点为空时，node取栈顶值并弹出
                treeNode = stack.pop();
                //左节点已经检查完，检查右节点
                treeNode = treeNode.getRightTreeNode();
            }
        }
    }


    //中序遍历 【左、根、右】
    public static void inOrder_Stack(TreeNode root){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;

        while(treeNode != null || stack.size()>0){
            if(treeNode != null){
                //直接压栈
                stack.push(treeNode);
                treeNode = treeNode.getLeftTreeNode();
            }else{
                //出栈并访问
                treeNode = stack.pop();
                printNode(treeNode);
                treeNode = treeNode.getRightTreeNode();
            }
        }
    }


    //后续遍历 【左、右、根】
    public static void postOrder_Stack(TreeNode root){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        //构造一个中间栈来存储逆后续遍历的结果
        Stack<TreeNode> output = new Stack<TreeNode>();

        TreeNode treeNode = root;
        while(treeNode != null || stack.size()>0){
            if(treeNode != null){
                output.push(treeNode);
                stack.push(treeNode);
                treeNode = treeNode.getRightTreeNode();
            }else{
                treeNode = stack.pop();
                treeNode = treeNode.getLeftTreeNode();
            }
        }

        while(output.size()>0){
            printNode(output.pop());
        }

    }


    public static void main(String[] args){

        TreeNode root = init();

        System.out.println("先序遍历（栈实现）");
        preOrder_stack(root);
        System.out.println("");

        System.out.println("中序遍历（栈实现）");
        inOrder_Stack(root);
        System.out.println("");

        System.out.println("后序遍历（栈实现）");
        postOrder_Stack(root);
        System.out.println("");
    }



}

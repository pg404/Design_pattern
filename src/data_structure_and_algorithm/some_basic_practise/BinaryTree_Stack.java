package data_structure_and_algorithm.some_basic_practise;

import java.util.Stack;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm
 * Author:Alan Ruan
 * Date:2018-11-19 18:32
 * Description://TODO 通过栈实现二叉树的先序中序后序三种遍历（非递归）
 *
 */
public class BinaryTree_Stack {


    public static Node init(){

        return BinaryTree_DiGui.init();


    }

    //打印节点数值
    public static void printNode(Node node){
        System.out.print(node.getData());
    }


    //先序遍历 【根、左、右】
    public static void preOrder_stack(Node root){

        Stack<Node> stack = new Stack<Node>();
        Node node = root;


        while(node != null || stack.size()>0){
            //将所有左孩子压栈
            if(node != null){
                //压栈之前先访问
                printNode(node);
                stack.push(node);
                node = node.getLeftNode();

            }else{
                //节点为空时，node取栈顶值并弹出
                node = stack.pop();
                //左节点已经检查完，检查右节点
                node = node.getRightNode();
            }
        }
    }


    //中序遍历 【左、根、右】
    public static void inOrder_Stack(Node root){

        Stack<Node> stack = new Stack<Node>();
        Node node = root;

        while(node != null || stack.size()>0){
            if(node != null){
                //直接压栈
                stack.push(node);
                node = node.getLeftNode();
            }else{
                //出栈并访问
                node = stack.pop();
                printNode(node);
                node = node.getRightNode();
            }
        }
    }


    //后续遍历 【左、右、根】
    public static void postOrder_Stack(Node root){

        Stack<Node> stack = new Stack<Node>();
        //构造一个中间栈来存储逆后续遍历的结果
        Stack<Node> output = new Stack<Node>();

        Node node = root;
        while(node != null || stack.size()>0){
            if(node != null){
                output.push(node);
                stack.push(node);
                node = node.getRightNode();
            }else{
                node = stack.pop();
                node = node.getLeftNode();
            }
        }

        while(output.size()>0){
            printNode(output.pop());
        }

    }


    public static void main(String[] args){

        Node root = init();

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

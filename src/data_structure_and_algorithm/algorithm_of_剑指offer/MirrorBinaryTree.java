package data_structure_and_algorithm.algorithm_of_剑指offer;

import data_structure_and_algorithm.Node;

import java.util.ArrayList;
import java.util.Stack;

import static data_structure_and_algorithm.BinaryTree_DiGui.init;
import static data_structure_and_algorithm.algorithm_of_剑指offer.PrintBinaryTreeFromTopToBottom.print;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-26 15:04
 * Description://TODO 19.操作给定的二叉树，将其变换为源二叉树的镜像。
 * 思路：使用递归或非递归方式交换每个节点的左右子树位置。
 */
public class MirrorBinaryTree {

    public static void main(String[] args){

        Node root = init();
        System.out.println("变换前的二叉树按层遍历为：");
        ArrayList<Integer> arrayList = print(root);
        for (Integer i:arrayList){
            System.out.print(i + " ");
        }
        Node temp= mirror(root);
        System.out.println("\n变换后的镜像二叉树按层遍历是：");
        ArrayList<Integer> arrayList2 = print(root);
        for (Integer i:arrayList2){
            System.out.print(i + " ");
        }

    }

    public static Node mirror(Node root){

        if (root == null){
            return null;
        }
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                Node temp = root.getLeftNode();
                root.setLeftNode(root.getRightNode());
                root.setRightNode(temp);
                stack.push(root);
                root = root.getLeftNode();
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                root = root.getRightNode();
            }
        }

        return root;
    }

}

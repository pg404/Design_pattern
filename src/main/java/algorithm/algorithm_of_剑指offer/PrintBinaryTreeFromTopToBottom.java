package algorithm.algorithm_of_剑指offer;

import algorithm.some_basic_practise.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

import static algorithm.some_basic_practise.BinaryTree_DiGui.init;

/**
 * Project:Exercise
 * Package:main.java.algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-25 17:41
 * Description://TODO 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路：利用队列（链表）辅助实现。
 *
 * 就是按层打印
 *
 */
public class PrintBinaryTreeFromTopToBottom {

    public static void main(String[] args){
        TreeNode root = init();
        ArrayList<Integer> arrayList = print(root);
        for (Integer i:arrayList){
            System.out.println(i);
        }


    }

    public static ArrayList<Integer> print(TreeNode root){

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null){
            return arrayList;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);

        while (!linkedList.isEmpty()){

            TreeNode treeNode = linkedList.poll();  //查询并移除链表的第一个元素
            arrayList.add(treeNode.getData());

            if (treeNode.getLeftTreeNode() != null){
                linkedList.addLast(treeNode.getLeftTreeNode());
            }
            if (treeNode.getRightTreeNode() !=null){
                linkedList.addLast(treeNode.getRightTreeNode());
            }



        }
        return arrayList;
    }

}

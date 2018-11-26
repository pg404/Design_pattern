package data_structure_and_algorithm.algorithm_of_剑指offer;

import data_structure_and_algorithm.Node;

import java.util.ArrayList;
import java.util.LinkedList;

import static data_structure_and_algorithm.BinaryTree_DiGui.init;

/**
 * Project:Exercise
 * Package:data_structure_and_algorithm.algorithm_of_剑指offer
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
        Node root = init();
        ArrayList<Integer> arrayList = print(root);
        for (Integer i:arrayList){
            System.out.println(i);
        }


    }

    public static ArrayList<Integer> print(Node root){

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null){
            return arrayList;
        }
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(root);

        while (!linkedList.isEmpty()){

            Node node = linkedList.poll();  //查询并移除链表的第一个元素
            arrayList.add(node.getData());

            if (node.getLeftNode() != null){
                linkedList.addLast(node.getLeftNode());
            }
            if (node.getRightNode() !=null){
                linkedList.addLast(node.getRightNode());
            }



        }
        return arrayList;
    }

}

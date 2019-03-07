package algorithm.algorithm_of_剑指offer;

import algorithm.some_basic_practise.TreeNode;

import static algorithm.some_basic_practise.BinaryTree_DiGui.init;

/**
 * Project:Exercise
 * Package:main.java.algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-12-05 11:15
 * Description://TODO 39.输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路
 * 径，最长路径的长度为树的深度。
 */
public class TreeDepth {

    public static void main(String[] args) {
        TreeNode root = init();
        System.out.println(treeDepth(root));

    }

    private static int treeDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = treeDepth(root.getLeftTreeNode());
        int right = treeDepth(root.getRightTreeNode());

        return left > right ? left + 1 : right + 1;
    }

}

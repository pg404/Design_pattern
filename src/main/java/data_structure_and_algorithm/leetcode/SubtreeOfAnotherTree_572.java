package main.java.data_structure_and_algorithm.leetcode;

import main.java.data_structure_and_algorithm.some_basic_practise.TreeNode;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.leetcode
 * Author:Alan Ruan
 * Date:2018-12-13 18:48
 * Description://TODO  Given two non-empty binary trees s and t,
 * check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 */
public class SubtreeOfAnotherTree_572 {

    public static void main(String[] args) {

        TreeNode e = new TreeNode(2,null, null);
        TreeNode d = new TreeNode(1,null,null);
        TreeNode c = new TreeNode(4,d,e);
        TreeNode b = new TreeNode(5,null,null);
        TreeNode s = new TreeNode(3,c,b);

        TreeNode C = new TreeNode(2,null, null);
        TreeNode B = new TreeNode(1,null, null);
        TreeNode t = new TreeNode(4,B,C);

        System.out.println(isSubTree(s,t));

    }

    private static boolean isSubTree(TreeNode s, TreeNode t){
        if (s == null){
            return false;
        }
        if (isSame(s,t)){
            return true;
        }
        return isSubTree(s.getLeftTreeNode(), t) || isSubTree(s.getRightTreeNode(), t);

    }

    private static boolean isSame(TreeNode s, TreeNode t){
        if (s == null && t == null){
            return s == t;
        }
        if (s.getData() != t.getData()){
            return false;
        }
        return isSame(s.getLeftTreeNode(), t.getLeftTreeNode()) && isSame(s.getRightTreeNode() , t.getRightTreeNode());
    }

}

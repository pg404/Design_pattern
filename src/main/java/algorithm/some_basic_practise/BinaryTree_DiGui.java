package algorithm.some_basic_practise;

/**
 * Project:Exercise
 * Package:main.java.algorithm
 * Author:Alan Ruan
 * Date:2018-11-19 17:16
 * Description://TODO  二叉树先序中序后序遍历，递归方式
 */
public class BinaryTree_DiGui {

    public static void main(String[] args){

        TreeNode root = init();
        System.out.println("先序遍历");
        preOrder(root);
        System.out.println("");

        System.out.println("中序遍历");
        inOrder(root);
        System.out.println("");

        System.out.println("后序遍历");
        postOrder(root);
        System.out.println("");


    }

    //注意必须逆序简历，先建立子节点，再逆序往上建立，
    //因为非叶子节点会使用到下面的节点，而初始化是按顺序初始化得，不逆序建立会报错

    public static TreeNode init(){

        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);
        //返回根节点
        return A;
    }

    //打印节点数值
    public static void printNode(TreeNode treeNode){
        System.out.print(treeNode.getData());
    }


    //先序遍历
    public static void preOrder(TreeNode root){

        //打印根节点
        printNode(root);

        if(root.getLeftTreeNode() != null){
            //使用递归遍历左孩子
            preOrder(root.getLeftTreeNode());
        }
        if(root.getRightTreeNode() != null){
            //使用递归遍历右孩子
            preOrder(root.getRightTreeNode());
        }
    }


    //中序遍历
    public static void inOrder(TreeNode root){

        if(root.getLeftTreeNode() != null){
            //使用递归遍历左孩子
            inOrder(root.getLeftTreeNode());
        }

        //打印根节点
        printNode(root);

        if(root.getRightTreeNode() != null){
            //使用递归遍历右孩子
            inOrder(root.getRightTreeNode());
        }
    }

    //后续遍历
    public static void postOrder(TreeNode root){

        if(root.getLeftTreeNode() != null){
            //使用递归遍历左孩子
            postOrder(root.getLeftTreeNode());
        }

        if(root.getRightTreeNode() != null){
            //使用递归遍历右孩子
            postOrder(root.getRightTreeNode());
        }

        //打印根节点
        printNode(root);
    }


}

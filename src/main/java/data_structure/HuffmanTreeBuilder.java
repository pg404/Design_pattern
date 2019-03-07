package data_structure;

import java.util.*;

/**
 * Project: SomethingAboutJava
 * Package: data_structure
 * Author: Alan Ruan
 * Date: 2019-03-05  20:57
 * Description: //TODO 构建哈夫曼树 【https://www.jianshu.com/p/bd6772a711d0】
 */
public class HuffmanTreeBuilder {

    public static void main(String[] args) {
        List<Node> nodes = Arrays.asList(
                new Node(1),
                new Node(3),
                new Node(4),
                new Node(5),
                new Node(7)
        );

        Node node = HuffmanTreeBuilder.build(nodes);
        printTree(node);

    }


    /**
     * @Method: build
     * @Param: [nodes]
     * @Return data_structure.Node
     * @Author: Alan Ruan
     * @Date: 2019/03/05 21:00:58
     * @Description: //TODO 构建哈夫曼树
     */
    private static Node build(List<Node> nodes){
        nodes = new ArrayList<Node>(nodes);
        sortList(nodes);
        while (nodes.size() > 1){
            createAndReplace(nodes);
        }
        return nodes.get(0);

    }


    /**
     * @Method: createAndReplace
     * @Param: [nodes]
     * @Return void
     * @Author: Alan Ruan
     * @Date: 2019/03/05 21:02:26
     * @Description: //TODO  组合两个权值最小节点，并在节点列表中用它们的父节点替换它们
     */
    private static void createAndReplace(List<Node> nodes){
        Node left = nodes.get(0);
        Node right = nodes.get(1);
        Node parent  = new Node(left.getValue() + right.getValue());
        parent.setLeftChild(left);
        parent.setRightChild(right);
        nodes.remove(0);
        nodes.remove(0);
        nodes.add(parent);
        sortList(nodes);
    }


    /**
     * @Method: sortList
     * @Param: [nodes]
     * @Return void
     * @Author: Alan Ruan
     * @Date: 2019/03/05 21:03:49
     * @Description: //TODO  将节点集合由小到大排序
     */
    private static void sortList(List<Node> nodes){
        Collections.sort(nodes);
    }

    /**
     * @Method: printTree
     * @Param: [node]
     * @Return void
     * @Author: Alan Ruan
     * @Date: 2019/03/05 21:04:48
     * @Description: //TODO  打印树结构，显示的格式是node(left,right)
     */
    public static void printTree(Node node){
        Node left = null;
        Node right = null;
        if (node != null){
            System.out.print(node.getValue());
            left = node.getLeftChild();
            right = node.getRightChild();
            System.out.println("(" + (left != null ? left.getValue() : " ") + "," + (right != null ? right.getValue() : " ") + ")");
        }
        if (left != null){
            printTree(left);
        }
        if (right!= null){
            printTree(right);
        }
    }


}

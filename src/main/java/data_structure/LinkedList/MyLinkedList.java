package data_structure.LinkedList;

/**
 * Project: SomethingAboutJava
 * Package: data_structure
 * Author: Alan Ruan
 * Date: 2019-03-08  16:23
 * Description: //TODO 一个链表类
 */
public class MyLinkedList {

    private LinkedNode headNode;

    private LinkedNode tempNode;

    public LinkedNode getHeadNode() {
        return headNode;
    }

    public void setHeadNode(LinkedNode headNode) {
        this.headNode = headNode;
    }

    //链表初始化
    public MyLinkedList(){
        LinkedNode node = new LinkedNode("王重阳",null);

        LinkedNode head = new LinkedNode(null, node);
    }

    /**
     * @Method: insert
     * @Param: [newNode, position]
     * @Return void
     * @Author: Alan Ruan
     * @Date: 2019/03/08 16:28:50
     * @Description: //TODO 1.插入节点
     */
    public void insert(LinkedNode newNode, int position){
        tempNode = headNode;
        int i = 0;
        while (i < position){
            tempNode = tempNode.next;
            i++;
        }
        newNode.next = tempNode.next;
        tempNode.next = newNode;
    }

    /**
     * @Method: delete
     * @Param: [position]
     * @Return void
     * @Author: Alan Ruan
     * @Date: 2019/03/08 16:30:55
     * @Description: //TODO 2.删除节点
     */
    public void delete(int position){

        tempNode = headNode;
        int i = 0;
        while (i < position){
            tempNode = tempNode.next;
            i++;
        }
        tempNode.next = tempNode.next.next;
    }


    /**
     * @Method: find
     * @Param: [position]
     * @Return data_structure.LinkedList.LinkedNode
     * @Author: Alan Ruan
     * @Date: 2019/03/08 16:33:55
     * @Description: //TODO 3.查找结点
     */
    public LinkedNode find(int position){
        tempNode = headNode;
        int i = 0;
        while(i < position){
            tempNode = tempNode.next;
            i++;
        }
        return tempNode.next;
    }


    /**
     * @Method: size
     * @Param: []
     * @Return int
     * @Author: Alan Ruan
     * @Date: 2019/03/08 16:34:49
     * @Description: //TODO 4.计算链表长度
     */
    public int size(){
        tempNode = headNode.next;
        int size = 0;
        while (tempNode.next != null){
            size += 1;
            tempNode = tempNode.next;
        }
        size = size +1;
        return size;
    }


    /**
     * @Method: showAll
     * @Param: []
     * @Return void
     * @Author: Alan Ruan
     * @Date: 2019/03/08 16:38:46
     * @Description: //TODO 5.打印所有节点
     */
    public void showAll(){
        tempNode = headNode;
        while (tempNode.next != null){
            System.out.println(tempNode.element);
            tempNode = tempNode.next;
        }
        System.out.println(tempNode.element);
    }


}


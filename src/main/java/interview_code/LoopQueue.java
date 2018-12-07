package main.java.interview_code;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Project:Exercise
 * Package:main.java.interview_code
 * Author:Alan Ruan
 * Date:2018-11-27 17:27
 * Description://TODO  招银二面手撕代码题  实现一个循环队列
 */
public class LoopQueue<T> implements Serializable {

    private int DEFAULT_SIZE = 10;

    private int capacity;

    private Object[] elementData;

    private int front = 0;

    private int rear = 0;

    //以默认数组长度创建空循环队列
    public LoopQueue(){
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    //以一个初始元素来创建循环队列
    public LoopQueue(T element){
        this();
        elementData[0] =  element;
        rear++;
    }

    //以指定长度的数组来创建循环队列
    public LoopQueue(T element, int initSize){
        this.capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }


    /**
     * @Method isEmpty
     * @Description //TODO
     * @Author Alan Ruan
     * @Date 2018/11/27 20:17:21
     * @Param []
     * @Return boolean
     */
    public boolean isEmpty(){
        return rear == front && elementData[rear] == null;
    }

    /**
     * @Method size
     * @Description //TODO  获取循环队列的大小
     * @Author Alan Ruan
     * @Date 2018/11/27 20:04:41
     * @Param []
     * @Return int
     */
    public int size(){
        if (isEmpty()){
            return 0;
        }
        return rear > front ? rear - front : capacity - (front - rear);
    }

    /**
     * @Method add
     * @Description //TODO 插入队列
     * @Author Alan Ruan
     * @Date 2018/11/27 20:23:19
     * @Param [element]
     * @Return void
     */
    public void add(T element){
        if (rear == front && elementData[front] != null){
            throw new IndexOutOfBoundsException("队列已满异常");
        }
        elementData[rear++] = element;
        //如果rear已经到头就转头
        rear = rear == capacity ? 0 : rear;

    }

    /**
     * @Method remove
     * @Description //TODO  移除队列
     * @Author Alan Ruan
     * @Date 2018/11/27 20:25:49
     * @Param []
     * @Return T
     */
    public T remove(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("空队列异常");
        }
        //保留队列的rear端元素的值
        T oldValue = (T) elementData[front];

        //释放队列的rear端的元素
        elementData[front++] = null;

        //如果front已经到头，那就转头
        front = front == capacity ? 0 : front;
        return oldValue;

    }

    /**
     * @Method element
     * @Description //TODO  返回队列顶端元素但不删除
     * @Author Alan Ruan
     * @Date 2018/11/27 20:26:36
     * @Param []
     * @Return T
     */
    public T element() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        return (T) elementData[front];
    }

    /**
     * @Method clear
     * @Description //TODO 清空循环队列
     * @Author Alan Ruan
     * @Date 2018/11/27 20:27:21
     * @Param []
     * @Return void
     */
    public void clear() {
        //将底层数组所有元素赋为null
        Arrays.fill(elementData, null);
        front = 0;
        rear = 0;
    }

    /**
     * @Method toString
     * @Description //TODO 重写toString方法
     * @Author Alan Ruan
     * @Date 2018/11/27 20:33:19
     * @Param []
     * @Return java.lang.String
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            //如果front < rear，有效元素就是front到rear之间的元素
            if (front < rear) {
                StringBuilder sb = new StringBuilder("[");
                for (int i = front; i < rear; i++) {
                    sb.append(elementData[i].toString() + ", ");
                }
                int len = sb.length();
                return sb.delete(len - 2, len).append("]").toString();
            }
            //如果front >= rear，有效元素为front->capacity之间、0->front之间的
            else {
                StringBuilder sb = new StringBuilder("[");
                for (int i = front; i < capacity; i++) {
                    sb.append(elementData[i].toString() + ", ");
                }
                for (int i = 0; i < rear; i++) {
                    sb.append(elementData[i].toString() + ", ");
                }
                int len = sb.length();
                return sb.delete(len - 2, len).append("]").toString();
            }
        }
    }


    public static void main(String[] args) {
        LoopQueue<String> queue = new LoopQueue<String>("aa", 3);
        //添加两个元素
        queue.add("bbb");
        queue.add("cccc");

        //此时队列已满
        System.out.println(queue);

        //删除一个元素后，队列可以再多加一个元素
        queue.remove();
        System.out.println("删除一个元素后的队列：" + queue);

        //再次添加一个元素，此时队列又满
        queue.add("dddd");
        System.out.println(queue);
        System.out.println("队列满时的长度：" + queue.size());

        //删除一个元素后，队列可以再多加一个元素
        queue.remove();

        //再次加入一个元素，此时队列又满
        queue.add("eeee");
        System.out.println(queue);

        queue.clear();
        queue.add("ab");
        queue.add("aabb");
        queue.add("aaabbb");

        //toString方法输出
        System.out.println("使用重写后的toString方法输出为：\n" + queue.toString());

    }



}

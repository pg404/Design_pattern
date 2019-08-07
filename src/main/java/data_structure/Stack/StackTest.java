package data_structure.Stack;

/**
 * Project: SomethingAboutJava
 * Package: data_structure.Stack
 * Author: Alan Ruan
 * Date: 2019-04-01  16:34
 * Description: //TODO
 */
public class StackTest {

    public static void main(String[] args) {

        SeqStackOperate seqStackOperate = new SeqStackOperate();

        SeqStack seqStack = new SeqStack(5);

        seqStackOperate.push(seqStack, 1);
        seqStackOperate.push(seqStack, 2);
        seqStackOperate.push(seqStack, 3);
        seqStackOperate.push(seqStack, 4);
        seqStackOperate.push(seqStack, 5);
        seqStackOperate.push(seqStack, 6);

        System.out.println("栈当前长度： " + seqStackOperate.getLength(seqStack));

        System.out.println("出栈的元素是： "+ seqStackOperate.pop(seqStack));

        System.out.println("出栈一个元素后栈当前长度为： " + seqStackOperate.getLength(seqStack));

        System.out.println("当前栈顶元素为： "+ seqStackOperate.getTopData(seqStack));

    }

}

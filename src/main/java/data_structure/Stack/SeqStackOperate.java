package data_structure.Stack;

/**
 * Project: SomethingAboutJava
 * Package: data_structure.Stack
 * Author: Alan Ruan
 * Date: 2019-04-01  16:33
 * Description: //TODO
 */
public class SeqStackOperate {

    /**
     * @Method: init
     * @Param: [length]
     * @Return data_structure.Stack.SeqStack
     * @Author: Alan Ruan
     * @Date: 2019/04/01 16:10:40
     * @Description: //TODO 初始化  用指定大小的 length 实例化一个 SeqStack，然后使top指针指向-1
     */
    public SeqStack init(int length){
        SeqStack seqStack = new SeqStack(length);
        seqStack.top = -1;
        return seqStack;
    }


    /**
     * @Method: push
     * @Param: [seqStack, data]
     * @Return void
     * @Author: Alan Ruan
     * @Date: 2019/04/01 16:12:15
     * @Description: //TODO  进栈  将top指针加1，然后将新元素插入到top指针指向的位置。
     */
    public void push(SeqStack seqStack, Object data){
        if (seqStack.top == seqStack.data.length -1){
            return;
        }
        seqStack.top++;
        seqStack.data[seqStack.top] = data;
    }


    /**
     * @Method: pop
     * @Param: [seqStack]
     * @Return java.lang.Object
     * @Author: Alan Ruan
     * @Date: 2019/04/01 16:15:15
     * @Description: //TODO 出栈  删除top指针指向的元素，并使top指针减1
     */
    public Object pop(SeqStack seqStack){
        if (seqStack.top == -1){
            return null;
        }
        Object o = seqStack.data[seqStack.top];
        seqStack.data[seqStack.top] = null;
        seqStack.top--;
        return o;
    }


    /**
     * @Method: getTopData
     * @Param: [seqStack]
     * @Return java.lang.Object
     * @Author: Alan Ruan
     * @Date: 2019/04/01 16:16:33
     * @Description: //TODO  获取栈顶元素
     */
    public Object getTopData(SeqStack seqStack){
        if (seqStack.top == -1){
            return null;
        }
        return seqStack.data[seqStack.top];
    }


    /**
     * @Method: isEmpty
     * @Param: [seqStack]
     * @Return boolean
     * @Author: Alan Ruan
     * @Date: 2019/04/01 16:17:16
     * @Description: //TODO  判断是否为空
     */
    public boolean isEmpty(SeqStack seqStack){
        return seqStack.top == -1;
    }


    /**
     * @Method: isFull
     * @Param: [seqStack]
     * @Return boolean
     * @Author: Alan Ruan
     * @Date: 2019/04/01 16:18:12
     * @Description: //TODO  判断是否栈满
     */
    public boolean isFull(SeqStack seqStack){
        return seqStack.top == seqStack.data.length - 1;
    }


    /**
     * @Method: getLength
     * @Param: [seqStack]
     * @Return int
     * @Author: Alan Ruan
     * @Date: 2019/04/01 16:18:58
     * @Description: //TODO 获取栈元素个数
     */
    public int getLength(SeqStack seqStack){
        return seqStack.top + 1;
    }



}

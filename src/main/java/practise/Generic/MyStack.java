package practise.Generic;

import practise.Lambda.Hero;

import java.util.LinkedList;

/**
 * Project: SomethingAboutJava
 * Package: practise.Generic
 * Author: Alan Ruan
 * Date: 2019-03-21  19:55
 * Description: //TODO  设计一个支持泛型的栈MyStack
 * 设计这个类的时候，在类的声明上，加上一个<T>，表示该类支持泛型。
 * T是type的缩写，也可以使用任何其他的合法的变量，比如A,B,X都可以，但是一般约定成俗使用T，代表类型。
 */
public class MyStack<T> {

    LinkedList<T> values = new LinkedList<>();

    public void push(T t){
        values.addLast(t);
    }

    public T pull(){
        return values.removeLast();
    }

    public T peek(){
        return values.getLast();
    }

    public static void main(String[] args) {

        MyStack<Hero> heroMyStack = new MyStack<>();
        heroMyStack.push(new Hero());

//        heroMyStack.push(new Item());

        MyStack<String> stringMyStack = new MyStack<>();
        stringMyStack.push("fasdf");

//        stringMyStack.push(new Hero());

    }

}

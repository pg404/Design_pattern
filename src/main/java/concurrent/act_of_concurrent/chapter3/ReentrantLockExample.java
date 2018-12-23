package concurrent.act_of_concurrent.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Project:Exercise
 * Package:main.java.concurrent.act_of_concurrent.chapter3
 * Author:Alan Ruan
 * Date:2018-10-30 17:12
 * Description://TODO
 */
public class ReentrantLockExample {

    int a=0;

    ReentrantLock lock=new ReentrantLock();

    public void writer(){
        lock.lock();
        try {
            a++;
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args){
        ReentrantLockExample reentrantLockExample=new ReentrantLockExample();
        reentrantLockExample.writer();
    }

}

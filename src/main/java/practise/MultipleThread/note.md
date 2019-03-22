####把上述3种方式再整理一下：
1. 继承Thread类
2. 实现Runnable接口
3. 匿名类的方式
>注： 启动线程是start()方法，run()并不能启动一个新的线程


####留意wait()和notify() 这两个方法是什么对象上的？

 
public synchronized void hurt() {
  。。。
  this.wait();
  。。。
}
 
public synchronized void recover() {
   。。。
   this.notify();
}

这里需要强调的是，wait方法和notify方法，并不是Thread线程上的方法，它们是Object上的方法。 

因为所有的Object都可以被用来作为同步对象，所以准确的讲，wait和notify是同步对象上的方法。

wait()的意思是： 让占用了这个同步对象的线程，临时释放当前的占用，并且等待。 所以调用wait是有前提条件的，一定是在synchronized块里，否则就会出错。

notify() 的意思是，通知一个等待在这个同步对象上的线程，你可以苏醒过来了，有机会重新占用当前对象了。

notifyAll() 的意思是，通知所有的等待在这个同步对象上的线程，你们可以苏醒过来了，有机会重新占用当前对象了。

####总结Lock和synchronized的区别
1. Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现，Lock是代码层面的实现。

2. Lock可以选择性的获取锁，如果一段时间获取不到，可以放弃。synchronized不行，会一根筋一直获取下去。 借助Lock的这个特性，就能够规避死锁，synchronized必须通过谨慎和良好的设计，才能减少死锁的发生。

3. synchronized在发生异常和同步块结束的时候，会自动释放锁。而Lock必须手动释放， 所以如果忘记了释放锁，一样会造成死锁



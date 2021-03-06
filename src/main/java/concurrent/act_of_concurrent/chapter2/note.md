##第二章 Java并发机制的底层实现原理

###一、volatile的应用

如果volatile变量修饰符使用得当，它比synchronized的使用和执行成本更低， 因为它不会引起线程上下文的切换和调度。

####1. volatile的定义和实现原理

有volatile变量修饰符的共享变量进行写操作的时候会多出一个lock前缀的指令

lock前缀的指令在多核处理器中引发两件事情

（1）将当前处理器缓存行的数据写回内存

（2）这个写回内存的操作会使在其他CPU里缓存了该内存地址的数据无效

>为了提高处理速度，处理器不直接和内存通信，而是先将内存中的数据读到cache中再进行操作，但操作完全不知道何时会写到内存。如果对声明了volatile变量的进行写操作 ，JVM就会向处理器发送一条Lock前缀的指令，将这个变量所在缓存行的数据写回到系统内存。 但是，就算写回到内存，如果其他处理器缓存的值还是旧的，再进行计算操作就会有问题。所以， 多处理器下，要实行缓存一致性协议，每个处理器通过嗅探在总线上传播的数据来检查自己缓存的值是不是过期，如果过期，就将当前处理器的缓存行设置成无效状态，当处理器对这个数据进行 修改操作的时候，会重新从系统内存中把数据读到处理器缓存中。

####2. volatile使用优化

将共享变量追加到64字节(貌似不生效了，在源码中没看到)

LinkedTransferQueue

>处理器的Cache的高速缓存行是64字节，不支持部分填充缓存行。通过追加到64字节的方式 来填满高速缓冲区的缓存行，避免头结点和尾节点加载到同一个缓存行，使头、尾节点在修改时不会互相锁定。

并不是所有使用volatile变量的时候都要追加到64字节

(1).缓存行非64字节宽  
(2).共享变量不会被频繁读写
###二、synchronized的实现原理与应用（重量级锁）

synchronize基础：java中的每个对象都可以作为锁。具体表现为3种形式：

(1).对于普通同步方法，锁是当前实例对象  
(2).对于静态同步方法，锁是当前类的class对象  
(3).对于同步方法块，锁是synchronize括号里的对象  
>锁到底存在哪里？锁里面会存储什么信息？

Synchronized在JVM中的实现原理：

JVM基于进入和退出Monitor对象来实现方法同步和代码块同步，但两者的表现细节不同。

代码块同步使用monitorenter和monitorexit指令实现，而方法同步是使用另外一种实现方式实现的，细节 并没有在JVM中说明。但是，方法同步同样可以使用上述两个指令实现。

>monitorenter指令是在编译后插入到同步代码块的开始位置，而monitorexit是插入到方法结束处和异常处 ，JVM要保证每个monitorenter必须有对应的monitorexit与之配对。任何对象都有一个monitor与之关联， 且当一个monitor被持有后，它将处于锁定状态。线程执行到monitorenter指令时，将会尝试获取对象所对应的 monitor的所有权，即尝试获得对象的锁。


####1、java对象头

对象头三种数据：Mark Word（对象hashcode、锁信息等）、Class元数据地址、数组长度（数组类型的对象才有）， 这三种数据分别占据一个Word（4字节）。

mark word里存储的数据会随着锁标志位的变化而变化

####2、锁的升级与对比

from JDK1.6

锁一共有4中状态，由低到高为：无锁、偏向锁、轻量级锁、重量级锁，这几个状态会随着竞争情况逐渐升级。 锁可以升级但不能降级（提高获得锁和释放锁的效率）

#####偏向锁：

大多数情况下，锁不仅不存在多线程竞争，而且总是由同一线程多次获得，为了让线程获得锁的代价 更低，引入了偏向锁。

当一个线程访问同步块并获取锁时，会在对象头和栈帧的锁记录里存储锁偏向的线程ID，以后该线程在进入 和退出同步块时不需要进行CAS操作来加锁和解锁，只需简单测试对象头里的mark word里是否存储着指向 当前线程的偏向锁。

如果测试成功，表示线程已经获得了锁。如果测试失败，则需要再测试一下mark word中偏向锁的标识是否 设置成1：如果没有设置，则使用CAS竞争锁；如果设置了，则尝试使用CAS将对象头的偏向锁指向当前线程。

（1）偏向锁的撤销

偏向锁使用了一种等到竞争出现才释放锁的机制，所以当其他线程尝试竞争偏向锁时，持有偏向锁的 线程才会释放锁。偏向锁的撤销，需要等待全局安全点（在这个时间上没有正在执行的字节码）。

首先暂停拥有偏向锁的线程，，然后检查持有偏向锁的线程是否活着，如果线程不处于活动状态，则 将对象头设置成无锁状态；如果线程仍然活着，拥有偏向锁的栈会被执行，遍历偏向对象的锁记录，栈中的 锁记录和对象头的mark word要么重新偏向于其他线程，要么恢复到无锁或者标记对象不适合作为偏向锁。

>这一块还是不清楚，得上网再看看  

（2）关闭偏向锁

java6、7默认启用偏向锁，但是在程序启动后会有几秒延迟，如有必要可以关闭延迟 -XX:BiasedLockingStartupDelay=0,如果确定程序里所有的锁通常处于竞争状态，可以通过JVM参数关闭偏向锁： -XX:UseBaisedLocking=false,那么程序会默认进入轻量级锁状态

#####轻量级锁

（1）加锁

线程在执行同步块之前，JVM会先在当前线程的栈帧中创建用于存储锁记录的空间，并将对象头中的 Mark word复制到锁记录中（Displaced Mark Word）。然后线程尝试使用CAS将对象头中的 Mark word替换为指向锁记录的指针。如果成功，当前线程获得锁，如果失败，表示其他线程竞争锁， 当前线程便尝试使用自旋来获取锁。

（2）解锁

解锁时，会使用原子的CAS操作将Displaced Mark Word替换回到对象头，如果成功，则表示没有竞争发生。 如果失败，表示当前锁存在竞争，锁就会膨胀成重量级锁。

因为自旋会消耗CPU，为了避免无用的自旋，一旦升级成重量级锁，就不会再恢复到轻量级锁状态。当 锁处于这个状态下，其他线程试图获取锁时，都会被阻塞住，当持有锁的线程释放锁之后会唤醒这些线程， 被唤醒的线程就会进行新一轮的夺锁之争。

####3、锁的优缺点对比

偏向锁：  
>    优点：加锁解锁不需要额外的消耗  
    缺点：如果线程间存在锁竞争，会带来额外的锁撤销的消耗适用于只有一个线程访问同步块的场景

轻量级锁：  
>    优点：竞争的线程不会阻塞，提高了程序的响应速度  
    缺点：如果始终得不到锁竞争的线程，使用自旋会消耗CPU使用场景：追求响应时间，同步块执行速度非常快
    
重量级锁：  
>    优点：线程竞争不使用自旋，不会消耗CPU  
    缺点：线程阻塞，响应时间慢适用场景：追求吞吐量，同步块执行时间较长
###三、原子操作的实现原理

####1、术语

CAS：比较并交换  
缓存行：缓存的最小操作单位  
内存顺序冲突：一般由假共享引起，出现内存顺序冲突时，CPU必须清空流水线  
假共享：多个CPU同时修改同一个缓存行的不同部分而引起其中一个CPU的操作无效
####2、处理器实现原子操作

（1）通过总线锁保证原子性

如果多个处理器同时对共享变量进行读改写操作（i++），那么共享变量就会被多个处理器同时进行操作， 这样读改写操作就不是原子的，操作完之后共享变量的值会和期望的不一致。

>总线锁：当一个处理器在总线上输出LOCK #信号时，其他处理器的请求将被阻塞住，那么该处理器 可以独占共享内存。

（2）使用缓存锁保证原子性

总线锁定把CPU和内存之间的通信锁住了，锁定期间，其他处理器不能操作其他内存地址的数据， 因此总线锁定的开销比较大。

>缓存锁定：内存区域如果被缓存在处理器的缓存行中，并且在LOCK期间被锁定，那么当他执行锁操作 会写到内存时，处理器不在总线上声言LOCK #信号，而是修改内部的内存地址，并允许它的缓存一致性机制来保证 操作的原子性，因为缓存一致性机制会阻止同时修改由两个以上处理器缓存的内存区域数据，当 其他处理器回写已被锁定的缓存行的数据时，会使缓存行无效。

两种情况不会使用缓存锁定：
>    1、数据不能被缓存在处理器内部，或操作的数据跨多个缓存行，此时用总线锁定  
    2、有些处理器不支持缓存锁定
####3、Java实现原子操作（锁和循环CAS）

（1）循环CAS机制

处理器的CMPXCHG指令

自旋CAS：循环进行CAS操作直至成功为止

CAS实现原子操作的三大问题：

>1、ABA问题：A到B再到A，CAS检查值时会以为没有发生变化，实际却发生了变化，解决方式是
在变量前面追加版本号：1A到2B到3C  
2、循环时间长开销大：自旋CAS如果长时间不成功，会给CPU带来非常大的执行开销  
3、只能保证一个共享变量的原子操作：此时用锁或者将几个共享变量合并  

（2）锁机制

除了偏向锁，另外两种锁都使用了循环CAS机制,即当一个线程进入同步块的时候使用循环CAS的方式 获取锁，当他退出同步块的时候使用循环CAS释放锁。
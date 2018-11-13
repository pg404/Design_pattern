###一. 基本概念
####1.什么是大端和小端
1) Little-Endian就是低位字节排放在内存的低地址端，高位字节排放在内存的高地址端。
2) Big-Endian就是高位字节排放在内存的低地址端，低位字节排放在内存的高地址端。

举例说明：例如数字 *0x12345678* 在内存中表现形式为：

1）大端模式：  
低地址 -----------------> 高地址  
0x12  |  0x34  |  0x56  |  0x78

2）小端模式：  
低地址 ------------------> 高地址  
0x78  |  0x56  |  0x34  |  0x1  

####2.关于Java语言
Java语言是解释性语言，运行过程为，源代码经过Java编译器编译成字节码，然后再由JVM解释执行，
而C++/C语言为编译型语言，源代码经过编译和链接后生成可执行性二进制代码，
因此java语言的执行速度比C/C++慢，但是java语言能够跨平台执行

####3.&和&&的区别
&是按位与操作符，a&b是把a和b都转换为二进制数之后，然后再进行按位与的运算，而&&为逻辑与操作符，而且具有短路功能。

####4.String, StringBuffer和StringBuilder
 >String 类型和 StringBuffer 类型的主要性能区别其实在于 String 是不可变的对象, 因此在每次对 String 类型进行改变的时候其实都等同于生成了一个新的 String 对象，而如果是使用 StringBuffer 类则结果就不一样了，每次结果都会对 StringBuffer 对象本身进行操作，而不是生成新的对象。
 
####5.==和equals
 “==”比较的是值【变量(栈)内存中存放的对象的(堆)内存地址】   
 equal用于比较两个对象的值是否相同【不是比地址】
 >详细自己找资料
 
####6. Java语言中，Socket的连接和建立的原理

>网络上的两个程序通过一个双向的通信连接实现数据的交换，这个双向链路的一端称为一个Socket，
也称为套接字，可以用来实现不同的虚拟机或者不同的计算机之间的通信。
一般socket可以分为两种：  
1：面向连接的socket通信协议（TCP,传输控制协议）  
2：面向无连接的socket通信协议（UDP，用户数据报协议）

>任何一个socket都是由IP地址和端口号唯一确定的。

 （1）、Socket通信的步骤：  
                 ① 创建ServerSocket和Socket  
                 ② 打开连接到Socket的输入/输出流  
                 ③ 按照协议对Socket进行读/写操作  
                 ④ 关闭输入输出流、关闭Socket  
 （2）、服务器端：  
                 ① 创建ServerSocket对象，绑定监听端口  
                 ② 通过accept()方法监听客户端请求  
                 ③ 连接建立后，通过输入流读取客户端发送的请求信息  
                 ④ 通过输出流向客户端发送乡音信息  
                 ⑤ 关闭相关资源  
 （3）、客户端：  
                 ① 创建Socket对象，指明需要连接的服务器的地址和端口号  
                 ② 连接建立后，通过输出流想服务器端发送请求信息  
                 ③ 通过输入流获取服务器响应的信息  
                 ④ 关闭响应资源               

####7.ArrayList、vector和LinkedList
ArrayList和Vector是采用数组方式存储数据，此数组元素数大于实际存储的数据以便增加插入元素，都允许直接序号索引元素，但是插入数据要涉及到数组元素移动等内存操作，所以插入数据慢，查找有下标，所以查询数据快，
Vector由于使用了synchronized方法-线程安全，所以性能上比ArrayList要差，  
LinkedList使用双向链表实现存储，按序号索引数据需要进行向前或向后遍历，但是插入数据时只需要记录本项前后项即可，插入数据较快，但与此同时，linklist不是线程安全的。

####8.HashMap、Hashtable和TreeMap
[https://blog.csdn.net/wangxing233/article/details/79452946]  
HashTable，TreeMap不允许null值，key和value都不可以,HashMap允许null值，key和value都可以，但只能由一个null值。  
另外，HashMap和TreeMap是非线程安全的，Hashtable是线程安全的。

####9.Collection和Collections
Collection是个java.util下的接口，它是各种集合结构的父接口,继承与他有关的接口主要有List和Set。    
Collections是个java.util下的类，它包含有各种有关集合操作的静态方法。  
[https://blog.csdn.net/ymfwj/article/details/52117843]

####10.实现多线程的三种方法
[https://www.jianshu.com/p/9e489390fc46]  
1.继承Thread类  
2.实现Runnable接口  
3.实现Callable接口  

####11.



package test;

/**
 * Project: SomethingAboutJava
 * Package: test
 * Author: Alan Ruan
 * Date: 2018-12-21  17:46
 * Description: //TODO  **总结：**new String()与直接赋值都会在字符串放入常量池之前进行判断，如果不存在则放入，
 * 如果存在则不放入。但是，new String()会在堆中多开辟一块空间存储字符串的值。因此，我们在赋值过程中应多使用直接赋值
 */
public class StringEqual {

    public static void main(String[] args) {

        //test0
        System.out.println("Test0: ");
        String a = "ab";
        final String b = "b";
        String ab = "a" + b;

        String c = new String("ab");
        String d = new String("ab");

        System.out.println(a == ab);
        System.out.println(c == d);
        System.out.println(a == c);

        //test1
        //true  当两个字符串字面值连接时（相加），得到的新字符串依然是字符串字面值，保存在常量池中。
        System.out.println("Test1: ");
        String aa = "a1";
        String bb = "a" + 1;
        System.out.println(aa==bb);

        //test2
        //false  当字符串常量与String类型变量连接时，得到的新字符串不再保存在常量池中，而是在堆中新建一个String对象来存放
        System.out.println("Test2： ");
        String e = "ab";
        String ee = "b";
        String f = "a" + ee;
        System.out.println(e==f);

        //test3
        //true  注意此题与上一题的区别，此处是字符串字面值与String类型常量连接，得到的新字符串依然保存在常量池中
        System.out.println("Test3: ");
        String g = "ab";
        final String gg = "b";
        String h = "a" + gg;
        System.out.println(g==h);

        //test4
        //false  此题中第条语句：final String bb = getBB();其实与final String bb = new String(“b”);是一样的。
        // 也就是说return “b”会在堆中创建一个String对象保存”b”，虽然bb被定义成了final。可见并非定义为final的就保存在常量池中，
        // 很明显此处bb常量引用的String对象保存在堆中，因为getBB()得到的String已经保存在堆中了，
        // final的String引用并不会改变String已经保存在堆中这个事实。
        System.out.println("Test4:  ");
        String i = "ab";
        final String ii = getBB();
        String j = "a" + ii;
        System.out.println(i==j);


        //test5
        System.out.println("Test5:  ");



        //test6
        System.out.println("Test6:  ");



        //参考资料：  https://uule.iteye.com/blog/1343458
    }

    private static String getBB(){
        return "b";
    }

}

package test;

/**
 * Project: SomethingAboutJava
 * Package: test
 * Author: Alan Ruan
 * Date: 2019-03-22  21:51
 * Description: //TODO
 *
 *  1、return ：直接跳出当前的方法,返回到该调用的方法的语句处,继续执行
 *
 *  2.   break：在循环体内结束整个循环过程
 *
 *  3.  continue ：结束本次的循环，直接进行下一次的循环
 *
 */
public class BreakAndContinue {

    public static void main(String[] args) {

        int total = 0;
        for (int i = 0; i <4; i++){
            if (i == 1){
                continue;
            }
            if (i == 2){
                break;
            }
            total += i;
        }

        System.out.println(total);


        testBreak();
        testContinue();
        testReturn();

        System.out.println("主函数------------------");

    }



    private static void testBreak() {
        for (int i = 0; i < 5; i++) {

            if (i == 3) {
                break;
            }
            System.out.println("--break------------" + i);
        }

        System.out.println("--break-------for循环外-----");

    }

    private static void testContinue() {
        for (int i = 0; i < 5; i++) {

            if (i == 3) {
                continue;
            }
            System.out.println("--continue------------" + i);
        }

        System.out.println("--continue-------for循环外-----");

    }

    private static void testReturn() {
        for (int i = 0; i < 5; i++) {

            if (i == 3) {
                return;
            }
            System.out.println("--return------------" + i);
        }

        System.out.println("--return-------for循环外-----");

    }


//      return     ： 作用于方法，结束当前方法，主要用来返回方法返回值，当方法有返回值的时候，返回对应类型的返回
//                     值，没有返回值时，可以返回空，或者不返回

//  continue ： 作用于语法结构，结束当前方法，结束当前结构，主要用于循环的加速

//  break      ： 作用于语法结构，作用于结构结束当前结构，主要多用于循环和switch结构中



}

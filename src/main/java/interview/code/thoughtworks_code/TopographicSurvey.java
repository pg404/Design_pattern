package interview.code.thoughtworks_code;

import java.util.Scanner;

/**
 * Project: SomethingAboutJava
 * Package: interview.code.thoughtworks_code
 * Author: Alan Ruan
 * Date: 2019-03-24  21:34
 * Description: //TODO  还没完成 3月29日20:00前提交
 *
 * 要求一： 输出探测结果地图
 *
 * 接受两行输入，第一行是两个数字，用空格分隔，表示探测网格的大小
 * 第二行是一个字符串，表示无人机探测到的地形
 *
 * 程序需要输出一个相应大小的矩阵， 并且保证矩阵的相应位置对应探测到的地形
 *
 * 例如
 * 4 6
 * GRRGGGGGGRFFFFRGGFFGRRFF
 *
 * 输出
 * GRRGGG
 * FFRGGG
 * FFRGGF
 * FFRRGF
 *
 * 要求二：检测输入有效性
 * 1.无效的探测网格， 第一行的输入如果不能正确转换为相应探测网格的大小，输出错误信息“Incorrect mesh size”
 * 2.无效的地形字段， “Invalid cell type”  地形只包含R河流 G草原 F森林
 * 3.数据不匹配，字符长度与网格大小，“Data mismatch”
 *
 */

public class TopographicSurvey {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //输入检测
        int x, y;

        String s;

        x = scanner.nextInt();
        y = scanner.nextInt();
        s = scanner.next();

        System.out.println(x + " " + y + " " + s);

        //字符串检测
        if (s.contains("RGF")){
            System.out.println("Invalid cell type");
        }

        if (x * y != s.length()){
            System.out.println("Data mismatch");
        }


        survey(x, y, s);

    }

    public static void survey(int x, int y, String str){

        for (int i = 0 ; i < x; i++){
            for (int j = 0; j < y; j++){
                System.out.print(str.charAt(i + j));
            }
            System.out.println();
        }


    }

}

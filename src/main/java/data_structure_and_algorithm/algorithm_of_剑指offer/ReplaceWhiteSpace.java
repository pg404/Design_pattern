package main.java.data_structure_and_algorithm.algorithm_of_剑指offer;

import java.util.Scanner;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-22 16:07
 * Description://TODO  4.将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 思路：从后往前复制，数组长度会增加，或使用StringBuilder、StringBuffer类
 */
public class ReplaceWhiteSpace {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("0")){

//            StringBuffer stringBuffer = new StringBuffer(scanner.nextLine());
//
//            System.out.println(replaceSpace(stringBuffer));
//

            System.out.println(scanner.next());

        }




    }

    private static String replaceSpace(StringBuffer stringBuffer){

        if (stringBuffer == null){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < stringBuffer.length(); i++){
            if (String.valueOf(stringBuffer.charAt(i)).equals(" ")){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(stringBuffer.charAt(i));
            }
        }


        return String.valueOf(stringBuilder);

    }


}

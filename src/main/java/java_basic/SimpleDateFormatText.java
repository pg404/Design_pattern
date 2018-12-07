package main.java.java_basic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Project:Exercise
 * Package:main.java.java_basic
 * Author:Alan Ruan
 * Date:2018-11-08 16:11
 * Description://TODO
 */
public class SimpleDateFormatText {

    public static void main(String[] args){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy--MM--dd HH:mm:ss");
        Date curdate = new Date();
        System.out.println(simpleDateFormat.format(curdate));

    }

}

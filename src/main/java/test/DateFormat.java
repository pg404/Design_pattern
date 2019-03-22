package test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Project: SomethingAboutJava
 * Package: test
 * Author: Alan Ruan
 * Date: 2019-03-22  15:53
 * Description: //TODO
 */
public class DateFormat {

    public static String now(){
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(now());
    }

}

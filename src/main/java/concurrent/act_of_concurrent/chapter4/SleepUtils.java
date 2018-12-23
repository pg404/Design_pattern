package concurrent.act_of_concurrent.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Project:Exercise
 * Package:main.java.concurrent.act_of_concurrent.chapter4
 * Author:Alan Ruan
 * Date:2018-10-29 16:44
 * Description://TODO
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }

}

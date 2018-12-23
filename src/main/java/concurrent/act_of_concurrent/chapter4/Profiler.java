package concurrent.act_of_concurrent.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * Project:Exercise
 * Package:main.java.concurrent.act_of_concurrent.chapter4
 * Author:Alan Ruan
 * Date:2018-10-30 16:24
 * Description://TODO
 */
public class Profiler {

    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };
    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }
    public static void main(String[] args) throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }

}

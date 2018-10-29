package concurrent.act_of_concurrent.chapter4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Project:Exercise
 * Package:concurrent.act_of_concurrent
 * Author:Alan Ruan
 * Date:2018-10-29 15:47
 * Description://TODO 第四章 例子4.1
 */
public class MultiThread {

    public static void main(String [] args){
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo : threadInfos){
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }

    }

}

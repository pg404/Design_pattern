package demo.crawler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.JobBuilder.newJob;

/**
 * Project: SomethingAboutJava
 * Package: demo.crawler
 * Author: Alan Ruan
 * Date: 2019-04-30  21:39
 * Description: //TODO
 */
public class TimeUpdate {

    public void go() throws Exception{
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail job = newJob().withIdentity("job1", "group1").build();

        CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(
                cronSchedule("50 47 17 * * ?")
        ).build();

        Date ft = scheduler.scheduleJob(job, trigger);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(job.getKey() + "已被安排执行于：" + simpleDateFormat.format(ft) + "," +
                "并且以如下重复规则重复执行" + trigger.getCronExpression());

        scheduler.start();
    }

    public static void main(String[] args) throws Exception{
        TimeUpdate test = new TimeUpdate();
        test.go();
    }

}

package com.test;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 调用任务的类
 * @author lhy
 *
 */
public class SchedulerTest {
   public static void main(String[] args) {
   
	 //通过schedulerFactory获取一个调度器
	   SchedulerFactory schedulerfactory=new StdSchedulerFactory();
	   Scheduler scheduler=null;
	   try{
//		通过schedulerFactory获取一个调度器
		   scheduler=schedulerfactory.getScheduler();
		   
//		 创建jobDetail实例，绑定Job实现类
//		 指明job的名称，所在组的名称，以及绑定job类
		   JobDetail jobDetail=new JobDetail("job1", "jgroup1", MyJob.class);
		   
//		 定义调度触发规则，比如每1秒运行一次，共运行8次
		   SimpleTrigger simpleTrigger=new SimpleTrigger("simpleTrigger","triggerGroup");
//		 马上启动
		   simpleTrigger.setStartTime(new Date());
//		 间隔时间
		   simpleTrigger.setRepeatInterval(1000);
//		 运行次数
		   simpleTrigger.setRepeatCount(8);
		   
//		 把作业和触发器注册到任务调度中
		   scheduler.scheduleJob(jobDetail, simpleTrigger);
		   
//		 启动调度
		   scheduler.start();
		   
		   
	   }catch(SchedulerException e){
		   e.printStackTrace();
	   }
	   
}
}

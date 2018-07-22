package com.test;

import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * �����������
 * @author lhy
 *
 */
public class CronTriggerTest {
   public static void main(String[] args) {
   
	 //ͨ��schedulerFactory��ȡһ��������
	   SchedulerFactory schedulerfactory=new StdSchedulerFactory();
	   Scheduler scheduler=null;
	   try{
//		ͨ��schedulerFactory��ȡһ��������
		   scheduler=schedulerfactory.getScheduler();
		   
//		 ����jobDetailʵ������Jobʵ����
//		 ָ��job�����ƣ�����������ƣ��Լ���job��
		   JobDetail jobDetail=new JobDetail("job1", "jgroup1", MyJob.class);
		   
//		 ������ȴ�������ÿ������10��15ִ��
		   CronTrigger cornTrigger=new CronTrigger("cronTrigger","triggerGroup");
//       ִ�й�����ʽ
		   cornTrigger.setCronExpression("0 15 10 * * ? *");
//		 ����ҵ�ʹ�����ע�ᵽ���������
		   scheduler.scheduleJob(jobDetail, cornTrigger);
		   
//		 ��������
		   scheduler.start();
		   
		   
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   
}
}

package com.test;

import java.util.Date;

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
public class SchedulerTest {
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
		   
//		 ������ȴ������򣬱���ÿ1������һ�Σ�������8��
		   SimpleTrigger simpleTrigger=new SimpleTrigger("simpleTrigger","triggerGroup");
//		 ��������
		   simpleTrigger.setStartTime(new Date());
//		 ���ʱ��
		   simpleTrigger.setRepeatInterval(1000);
//		 ���д���
		   simpleTrigger.setRepeatCount(8);
		   
//		 ����ҵ�ʹ�����ע�ᵽ���������
		   scheduler.scheduleJob(jobDetail, simpleTrigger);
		   
//		 ��������
		   scheduler.start();
		   
		   
	   }catch(SchedulerException e){
		   e.printStackTrace();
	   }
	   
}
}

package com.test;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * ��Ҫִ�е�����
 * @author lhy
 *
 */
public class MyJob implements Job {

	@Override
	//��Ҫִ�еĲ�����д��execute������
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("����Quartz"+new Date());
	}

}

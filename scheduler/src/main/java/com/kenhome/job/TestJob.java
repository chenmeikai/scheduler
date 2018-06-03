package com.kenhome.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kenhome.utils.DateUtils;

public class TestJob implements Job {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // Do what you want here
    	
    	Date date =new Date();
    	
    	String time =DateUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    	
        logger.info("我是天空之王...");
        logger.info("当前时间："+time);
    }
}

package com.kenhome.config.quartz;

import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kenhome.job.ScheduleUtil;
import com.kenhome.model.ScheduleJob;
import com.kenhome.service.JobService;
import com.kenhome.utils.ServiceException;

import java.util.List;

/**
 * 项目启动后，自动加载执行存储到数据库的任务job
 * @Description:TODO  
 * @author: cmk 
 * @date:   2018年6月1日 下午11:17:04
 */
@Component
public class StartUpScheduler implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JobService jobService;

    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(String... args) throws Exception {

        // Run schedule job when Application startup
        List<ScheduleJob> scheduleJobList = jobService.getAllEnableJob();
        for (ScheduleJob scheduleJob : scheduleJobList) {
            try {
                CronTrigger cronTrigger = ScheduleUtil.getCronTrigger(scheduler, scheduleJob);
                if (cronTrigger == null) {
                    ScheduleUtil.createScheduleJob(scheduler, scheduleJob);
                } else {
                    ScheduleUtil.updateScheduleJob(scheduler, scheduleJob);
                }
                logger.info("Startup {}-{} success", scheduleJob.getJobGroup(), scheduleJob.getJobName());
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
    }
}

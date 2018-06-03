package com.kenhome.config.quartz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import javax.sql.DataSource;

/**
 * 
 * @Description:配置SchedulerFactory  
 * @author: cmk 
 * @date:   2018年6月1日 下午11:23:08
 */
@Configuration
public class ScheduleConfig {

    @Autowired
    private ScheduleJobFactory jobFactory;

    /**
     * To Configuration Quartz , not necessary, if not config this, will use default
     *
     * @param dataSource
     * @return
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("dataSource") DataSource dataSource) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setSchedulerName("TASK_EXECUTOR");
        schedulerFactoryBean.setStartupDelay(10);//延迟加载
        schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContextKey");//上下文
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.setDataSource(dataSource);//数据源
        // Make Spring manage instance of Job
        schedulerFactoryBean.setJobFactory(jobFactory);
        return schedulerFactoryBean;
    }
}

package com.kenhome.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.kenhome.common.CommonResponse;
import com.kenhome.common.ResponseUtil;
import com.kenhome.mapper.JobDao;
import com.kenhome.model.ScheduleJob;
import com.kenhome.service.JobService;
import com.kenhome.utils.ServiceException;

/**
 * @Description:动态设置定时任务
 * @author: cmk
 * @date: 2018年6月1日 下午10:27:33
 */

@Controller
@RequestMapping("job")
public class JobController {

    @Resource
    private JobService jobService;

    @Autowired
    private JobDao jobDao;


    @GetMapping("list")
    public String getList() {
        return "back/scheduler/jobList";
    }

    @GetMapping("getData")
    @ResponseBody
    public Map<String, Object> getAllJob() {

        Map<String, Object> result = new HashMap<String, Object>();

        List<ScheduleJob> scheduleJobs = jobService.getAllJob();

        result.put("code", 200);
        result.put("total", scheduleJobs.size());
        result.put("rows", scheduleJobs);

        return result;
    }

    /**
     * 任务编辑页
     *
     * @param jobId
     * @param request
     * @return
     * @throws ServiceException
     */
    @GetMapping("/edit/{id}")
    public String getJob(@PathVariable("id") Long jobId, HttpServletRequest request) throws ServiceException {

        ScheduleJob scheduleJob = jobDao.select(jobId);
        request.setAttribute("job", scheduleJob);
        return "back/scheduler/jobEdit";
    }


    /**
     * 更新任务
     *
     * @param jobId
     * @param newScheduleJob
     * @return
     * @throws ServiceException
     */
    @PutMapping("/edit/{id}")
    @ResponseBody
    public CommonResponse updateJob(@PathVariable("id") Long jobId, @RequestBody ScheduleJob newScheduleJob) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.update(jobId, newScheduleJob));
    }


    /**
     * 移出quartz的任务，任务状态为未激活
     *
     * @param jobId
     * @return
     * @throws ServiceException
     */
    @DeleteMapping("/unable/{id}")
    @ResponseBody
    public CommonResponse unableJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.unable(jobId));
    }

    /**
     * 加入任务到quartz，任务状态为激活
     *
     * @param jobId
     * @return
     * @throws ServiceException
     */
    @PutMapping("/enable/{id}")
    @ResponseBody
    public CommonResponse enableJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.enable(jobId));
    }

    /**
     * 删除任务，删除前，任务必须被移出quartz
     *
     * @param jobId
     * @return
     * @throws ServiceException
     */
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public CommonResponse deleteJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.delete(jobId));
    }

    /**
     * 新增任务页面
     *
     * @return
     */
    @GetMapping("/save")
    public String save() {
        return "back/scheduler/jobAdd";
    }

    /**
     * 新增任务，还未被激活
     *
     * @param newScheduleJob
     * @return
     * @throws ServiceException
     */
    @PostMapping("/save")
    @ResponseBody
    public CommonResponse saveJob(@RequestBody ScheduleJob newScheduleJob) throws ServiceException {

        return ResponseUtil.generateResponse(jobService.add(newScheduleJob));
    }


    /**
     * 启动任务，任务必须被激活
     *
     * @param jobId
     * @return
     * @throws ServiceException
     */
    @PutMapping("/run/{id}")
    @ResponseBody
    public CommonResponse runJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.run(jobId));
    }


    /**
     * 暂停任务，任务必须被加入到quartz
     *
     * @param jobId
     * @return
     * @throws ServiceException
     */
    @PutMapping("/pause/{id}")
    @ResponseBody
    public CommonResponse pauseJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.pause(jobId));
    }

    /**
     * 重启任务，任务必须被加入到quartz才可被重启
     *
     * @param jobId
     * @return
     * @throws ServiceException
     */
    @PutMapping("/resume/{id}")
    @ResponseBody
    public CommonResponse resumeJob(@PathVariable("id") Long jobId) throws ServiceException {
        return ResponseUtil.generateResponse(jobService.resume(jobId));
    }

}

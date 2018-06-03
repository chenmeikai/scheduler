/**   
 * Copyright © 2018 
 * @Package: CronController.java 
 * @author: Administrator   
 * @date: 2018年6月1日 下午10:21:17 
 */
package com.kenhome.controller;


import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**      
 * @Description:cron表达式生成 工具 
 * @author: cmk 
 * @date:   2018年6月1日 下午10:21:17     
 */

@Controller
@RequestMapping("job")
public class CronController {
	
	
	@RequestMapping("cron")
	public String cron(HttpServletResponse response) {
		
		return "redirect:/cron/cron.html";
		
	}

}

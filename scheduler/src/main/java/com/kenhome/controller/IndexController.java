
package com.kenhome.controller;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kenhome.service.AclService;

@Controller("backIndex")
@RequestMapping("manager")
public class IndexController  {
	
	@Resource
	private AclService aclService;
	
	
	@RequestMapping("index")
	public String index(Model model) {
		
		Map<String,Object>  map=aclService.selectRootAndChildAcl();
		
		model.addAttribute("data",map);
		
		return "back/index";
	}
	
	
	
	@RequestMapping("info")
	public String info(Map<String,Object> map) {
		
		
		return "back/info";
	}
	
}

package love.kill.demoformethodcachewithmemory.controller;

import love.kill.demoformethodcachewithmemory.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *
 *
 * @author Lycop
 */
@RestController
@RequestMapping("/demo")
public class Demo4MethodCache {

	@Autowired
	private DemoService demoService;

	@GetMapping("/withoutmethodcache")
	public String withoutMethodCache(){
		long start = new Date().getTime();
		return demoService.getDataWithoutMethodCache() + "(处理耗时：" + (new Date().getTime() -  start + "毫秒)");
	}


	@GetMapping("/withmethodcache")
	public String withMethodCache(){
		long start = new Date().getTime();
		return demoService.getDataWithMethodCache() + "(处理耗时：" + (new Date().getTime() -  start + "毫秒)");
	}
}

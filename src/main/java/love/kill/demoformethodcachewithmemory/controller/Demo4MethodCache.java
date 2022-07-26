package love.kill.demoformethodcachewithmemory.controller;

import love.kill.demoformethodcachewithmemory.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

/**
 *
 *
 * @author Lycop
 */
@EnableTransactionManagement
@RestController
@RequestMapping("/demo")
public class Demo4MethodCache {

	@Autowired
	private DemoService demoService;

	@Value("${server.port}")
	private String port;

	@GetMapping("/withoutmethodcache")
	public String withoutMethodCache(@RequestParam(value = "key",required = false) String key){
		long start = new Date().getTime();
		return demoService.getDataWithoutMethodCache(key) + "(处理耗时：" + (new Date().getTime() -  start + "毫秒)");
	}


	@GetMapping("/withmethodcache")
	public String withMethodCache(@RequestParam(value = "key",required = false) String key){
		long start = new Date().getTime();
		return demoService.getDataWithMethodCache(key) + "(处理耗时：" + (new Date().getTime() -  start + "毫秒)");
	}

	@GetMapping("/dosomethingandclear")
	public void clear(){

		// do something...

		// 清空指定缓存
		String url = "http://localhost:" + port + "/methodcache/cache";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("id", "getDataWithMethodCache");

		new RestTemplate().delete(builder.build(true).toUri());
	}
}

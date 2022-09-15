package love.kill.demoformethodcachewithmemory.controller;

import love.kill.demoformethodcachewithmemory.domain.DemoDTO;
import love.kill.demoformethodcachewithmemory.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 缓存demo
 *
 * @author Lycop
 */
@RestController
@RequestMapping("/demo")
public class Demo4MethodCache {

	@Autowired
	private DemoService demoService;

	/**
	 * 非缓存获取数据(1000毫秒)
	 */
	@GetMapping("/withoutmethodcache")
	public String withoutMethodCache(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "val", required = false) String val) {
		long start = new Date().getTime();

		DemoDTO demoDTO = new DemoDTO();
		demoDTO.setKey(key);
		demoDTO.setVal(val);
		return demoService.getWithoutCache(demoDTO).getResponse() + "（耗时：" + (new Date().getTime() - start + "毫秒）");
	}

	/**
	 * 缓存方式1(1000毫秒)
	 */
	@GetMapping("/withmethodcache_1")
	public String getWithMethodCache1(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "val", required = false) String val) {
		long start = new Date().getTime();

		DemoDTO demoDTO = new DemoDTO();
		demoDTO.setKey(key);
		demoDTO.setVal(val);
		return demoService.getWithCache1(demoDTO).getResponse() + "。（耗时：" + (new Date().getTime() - start + "毫秒）");
	}

	/**
	 * 缓存方式2(500毫秒)
	 */
	@GetMapping("/withmethodcache_2")
	public String getWithMethodCache2(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "val", required = false) String val) {
		long start = new Date().getTime();

		DemoDTO demoDTO = new DemoDTO();
		demoDTO.setKey(key);
		demoDTO.setVal(val);
		return demoService.getWithCache2(demoDTO).getResponse() + "(耗时：" + (new Date().getTime() - start + "毫秒)");
	}

	/**
	 * 缓存方式3(500毫秒)
	 */
	@GetMapping("/withmethodcache_3")
	public String getWithMethodCache3(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "val", required = false) String val) {
		long start = new Date().getTime();

		DemoDTO demoDTO = new DemoDTO();
		demoDTO.setKey(key);
		demoDTO.setVal(val);
		return demoService.getWithCache3(demoDTO) + "(耗时：" + (new Date().getTime() - start + "毫秒)");
	}

	/**
	 * 非缓存方式获取数据并删除缓存
	 * 获取成功后删除"缓存方式1"和"缓存方式2"对应的缓存
	 */
	@GetMapping("/getdelwithoutcache")
	public String getdelWithoutCache(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "val", required = false) String val) {
		long start = new Date().getTime();

		DemoDTO demoDTO = new DemoDTO();
		demoDTO.setKey(key);
		demoDTO.setVal(val);
		return demoService.getdelWithoutCache(demoDTO).getResponse() + "（耗时：" + (new Date().getTime() - start + "毫秒）");
	}


	/**
	 * 缓存方式获取并删除缓存
	 * 获取成功后删除"缓存方式2"和"缓存方式3"对应的缓存
	 */
	@GetMapping("/getdelwithcache")
	public String getdelwithcache(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "val", required = false) String val) {
		long start = new Date().getTime();

		DemoDTO demoDTO = new DemoDTO();
		demoDTO.setKey(key);
		demoDTO.setVal(val);
		return demoService.getdelWithCache(demoDTO).getResponse() + "（耗时：" + (new Date().getTime() - start + "毫秒）");
	}
}

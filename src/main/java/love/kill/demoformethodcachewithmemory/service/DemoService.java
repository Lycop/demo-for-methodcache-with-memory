package love.kill.demoformethodcachewithmemory.service;

import love.kill.demoformethodcachewithmemory.domain.DemoDTO;
import love.kill.methodcache.annotation.CacheData;

/**
 *
 *
 * @author Lycop
 */
public interface DemoService {

	/**
	 * 无缓存请求
	 * */
	DemoDTO getWithoutCache(DemoDTO demoDTO);

	/**
	 * 带缓存的请求1
	 * */
	@CacheData(id = "getWithCache1", refresh = false, remark = "从缓存获取数据例子_1")
	DemoDTO getWithCache1(DemoDTO demoDTO);

	/**
	 * 带缓存的请求2
	 * */
	@CacheData(id = "getWithCache2", refresh = false, remark = "从缓存获取数据例子_2")
	DemoDTO getWithCache2(DemoDTO demoDTO);

	/**
	 * 带缓存的请求3
	 * */
	@CacheData(id = "getWithCache3", refresh = false, remark = "从缓存获取数据例子_3")
	int getWithCache3(DemoDTO demoDTO);
}
package love.kill.demoformethodcachewithmemory.service;

import love.kill.demoformethodcachewithmemory.domain.DemoDTO;
import love.kill.methodcache.annotation.CacheData;
import love.kill.methodcache.annotation.DeleteData;

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
	 * 带缓存的请求1，共享式缓存数据
	 * */
	@CacheData(id = "getWithCache1", expiration = 60 * 60 * 1000L, shared = true, remark = "从缓存获取数据例子_1")
	DemoDTO getWithCache1(DemoDTO demoDTO);

	/**
	 * 带缓存的请求2
	 * */
	DemoDTO getWithCache2(DemoDTO demoDTO);

	/**
	 * 带缓存的请求3
	 * */
	@CacheData(id = "getWithCache3", expiration = 60 * 60 * 1000L, remark = "从缓存获取数据例子_3")
	int getWithCache3(DemoDTO demoDTO);

	/**
	 * 非缓存方式获取数据并删除缓存
	 * */
	@DeleteData(id = {"getWithCache1","getWithCache2"})
	DemoDTO getdelWithoutCache(DemoDTO demoDTO);

	/**
	 * 缓存方式获取数据并删除缓存
	 * */
	@CacheData(id = "getdelWithCache", expiration = 60 * 60 * 1000L, remark = "缓存方式获取数据并删除缓存")
	@DeleteData(id = {"getWithCache2","getWithCache3"})
	DemoDTO getdelWithCache(DemoDTO demoDTO);
}
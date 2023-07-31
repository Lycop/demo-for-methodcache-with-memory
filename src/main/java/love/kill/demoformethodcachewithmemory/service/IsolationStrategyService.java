package love.kill.demoformethodcachewithmemory.service;

import love.kill.demoformethodcachewithmemory.domain.DemoDTO;
import love.kill.methodcache.annotation.CacheData;
import love.kill.methodcache.annotation.DeleteData;

/**
 *
 *
 * @author Lycop
 */
public interface IsolationStrategyService {

	/**
	 * 无缓存的循环请求
	 * */
	DemoDTO loopWithoutCache(DemoDTO demoDTO);

	/**
	 * 带缓存的循环请求
	 * */
	DemoDTO loopWithCache(DemoDTO demoDTO);
}
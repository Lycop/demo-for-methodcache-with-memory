package love.kill.demoformethodcachewithmemory.service;

import love.kill.demoformethodcachewithmemory.domain.DemoDTO;
import love.kill.demoformethodcachewithmemory.domain.ResponseDTO;
import love.kill.methodcache.annotation.CacheData;
import love.kill.methodcache.annotation.CacheDataAssert;
import love.kill.methodcache.annotation.DeleteData;
import love.kill.methodcache.annotation.ResultDataAssert;

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

	/**
	 * 断言执行结果
	 *
	 * 如果执行结果(ResponseDTO::code)为0，则表示此次请求符合预期，将结果缓存下来；否则不缓存。
	 */
	@CacheData(expiration = 60 * 60 * 1000L, resultDataAssert = AssertResultCodeEqualsZero.class)
	ResponseDTO demo4AssertResult(int dividend);

	/**
	 * 断言执行结果Code为0
	 * */
	class AssertResultCodeEqualsZero implements ResultDataAssert<ResponseDTO> {
		@Override
		public boolean doAssert(ResponseDTO resultData) {
			return resultData.getCode() == 0;
		}
	}

	/**
	 * 断言缓存
	 *
	 * 如果存在有效的缓存，但该值小于0，则不认可该结果，触发一次"实际请求"，并返回结果。
	 */
	@CacheData(expiration = 60 * 60 * 1000L, cacheDataAssert = AssertCacheDataGreaterThanZero.class)
	Integer demo4AssertCacheData(int dividend);

	/**
	 * 断言缓存的值大于0
	 * */
	class AssertCacheDataGreaterThanZero implements CacheDataAssert<Integer> {
		@Override
		public boolean doAssert(Integer cacheData) {
			return cacheData > 0;
		}
	}
}
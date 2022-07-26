package love.kill.demoformethodcachewithmemory.service.impl;

import love.kill.demoformethodcachewithmemory.service.DemoService;
import love.kill.methodcache.annotation.CacheData;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author Lycop
 */
@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public String getDataWithoutMethodCache(String key) {
		return doGetData(key);
	}

	@Override
	public String getDataWithMethodCache(String key) {
		return doGetData(key);
	}

	private String doGetData(String key){
		try {
			// 模拟耗时的业务处理
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello world! key=" + key;
	}
}

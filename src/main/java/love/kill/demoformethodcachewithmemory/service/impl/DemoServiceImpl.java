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
	public String getDataWithoutMethodCache() {
		return doGetData();
	}

	@CacheData
	@Override
	public String getDataWithMethodCache() {
		return doGetData();
	}

	private String doGetData(){
		try {
			// 模拟耗时的业务处理
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello world!";
	}
}

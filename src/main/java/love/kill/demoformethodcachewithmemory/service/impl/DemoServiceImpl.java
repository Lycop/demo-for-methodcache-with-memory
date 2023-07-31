package love.kill.demoformethodcachewithmemory.service.impl;

import love.kill.demoformethodcachewithmemory.domain.DemoDTO;
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
	public DemoDTO getWithoutCache(DemoDTO demoDTO) {
		return doGetData(demoDTO, 1000);
	}

	@Override
	public DemoDTO getWithCache1(DemoDTO demoDTO) {
		return doGetData(demoDTO, 1000);
	}

	@CacheData(id = "getWithCache2", expiration = 60 * 60 * 1000L, remark = "从缓存获取数据例子_2")
	@Override
	public DemoDTO getWithCache2(DemoDTO demoDTO) {
		return doGetData(demoDTO, 500);
	}

	@Override
	public int getWithCache3(DemoDTO demoDTO) {
		DemoDTO resultDTO = doGetData(demoDTO, 500);
		return resultDTO.getKey().hashCode() + resultDTO.getVal().hashCode();
	}

	@Override
	public DemoDTO getdelWithoutCache(DemoDTO demoDTO) {
		return doGetData(demoDTO, 1000);
	}

	@Override
	public DemoDTO getdelWithCache(DemoDTO demoDTO) {
		return doGetData(demoDTO, 1000);
	}

	/**
	 * 业务请求
	 */
	private DemoDTO doGetData(DemoDTO demoDTO, int sleep){
		try {
			// 模拟耗时的业务处理
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DemoDTO result = new DemoDTO();
		result.setKey(demoDTO.getKey());
		result.setVal(demoDTO.getVal());
		result.setResponse("hello world! key=" + demoDTO.getKey() + ", val=" + demoDTO.getVal());
		return result;
	}

}

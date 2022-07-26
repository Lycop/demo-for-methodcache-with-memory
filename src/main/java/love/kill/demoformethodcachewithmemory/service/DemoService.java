package love.kill.demoformethodcachewithmemory.service;

import love.kill.methodcache.annotation.CacheData;
import love.kill.methodcache.annotation.CapitalExpiration;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author Lycop
 */
@Service
public interface DemoService {

	String getDataWithoutMethodCache(String key);

	@CacheData(refresh = false,behindExpiration = 10000L, capitalExpiration = CapitalExpiration.DAY, id="getDataWithMethodCache")
	String getDataWithMethodCache(String key);

}

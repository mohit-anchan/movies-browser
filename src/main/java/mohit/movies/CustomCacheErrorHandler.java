package mohit.movies;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.lang.Nullable;

/**
 * Created by Awaneesh on 04/12/2019.
 */
public class CustomCacheErrorHandler implements CacheErrorHandler {

    @Override
    public void handleCacheGetError(RuntimeException exception,
                                    Cache cache,
                                    Object key) {

        exception.printStackTrace();

    }

    @Override
    public void handleCachePutError(RuntimeException exception,
                                    Cache cache,
                                    Object key,
                                    @Nullable
                                    Object value) {
        exception.printStackTrace();
    }

    @Override
    public void handleCacheEvictError(RuntimeException exception,
                                      Cache cache,
                                      Object key) {
        exception.printStackTrace();
    }

    @Override
    public void handleCacheClearError(RuntimeException exception,
                                      Cache cache) {
        exception.printStackTrace();
    }
}

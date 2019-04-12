package mohit.movies;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

/**
 * Created by Awaneesh on 10/22/2018.
 */
@Configuration
public class CacheConfiguration extends CachingConfigurerSupport {

    @Override
    @Nullable
    public CacheErrorHandler errorHandler() {
        return new CustomCacheErrorHandler();
    }

}

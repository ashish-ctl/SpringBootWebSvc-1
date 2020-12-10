package com.example.demo.config;
 
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class EhCacheConfiguration {

	@Bean
	public CacheManager getCacheManager() {
		EhCacheCacheManager cManager = new EhCacheCacheManager(cacheManagerFactory().getObject());
		return cManager;
	}
	
	@Bean
	public EhCacheManagerFactoryBean cacheManagerFactory() {
		System.out.println("cacheManagerFactory (+)");
		EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
		bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		bean.setShared(true);
		System.out.println("cacheManagerFactory (-)");
		return bean;
	}
	
}

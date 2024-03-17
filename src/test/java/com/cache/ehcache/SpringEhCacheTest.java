package com.cache.ehcache;

import com.cache.ehcache.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:ehcache/spring-ehcache.xml"})
public class SpringEhCacheTest {

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test1(){
        Cache userCache = cacheManager.getCache("user_cache");
        User user = new User();
        user.setId(1L);
        user.setName("³Â½üÄÏ");
        userCache.put(1L,user);
        User resUser = userCache.get(1L, User.class);
        System.out.println(resUser);
    }
}

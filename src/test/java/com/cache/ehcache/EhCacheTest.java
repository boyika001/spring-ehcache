package com.cache.ehcache;

import com.cache.ehcache.bean.User;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Test;

import java.util.Arrays;

public class EhCacheTest {
    @Test
    public void test2(){
        System.out.println(System.getProperty("java.io.tmpdir"));
    }

    @Test
    public void test1(){
        String absPath = "E:\\study_project_root\\ehcache-demo\\src\\main\\resources\\ehcache.xml";
        //用来管理多个Cache:user_cache,item_cache,store_cache...
        CacheManager cacheManager = CacheManager.create(absPath);
        String[] cacheNames = cacheManager.getCacheNames();
        System.out.println("CacheManager管理的所有cache的名字:"+ Arrays.toString(cacheNames));
        Cache user_cache = cacheManager.getCache("user_cache");
        User user = new User();
        user.setId(1L);
        user.setName("陈近南");
        Element element = new Element(user.getId(),user);
        user_cache.put(element);
        Element resEle = user_cache.get(1L);
        System.out.println("resEle:"+resEle);
        System.out.println("resEle'Value:"+resEle.getObjectValue());

    }
}

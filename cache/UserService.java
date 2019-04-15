package com.sonydafa.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

public class UserService {
    private CacheManager<User> cacheManager;
    public UserService(){
        this.cacheManager=new CacheManager<>();
    }
    public User getUserById(String userid){
        User result=cacheManager.getValue(userid);
        if(result!=null){
            System.out.println("Get from cache... "+userid);
            return result;
        }
        //对无缓冲进行管理
        result=getFromDB(userid);
        cacheManager.addOrUpdateCache(userid,result);
        return  result;
    }
    private User getFromDB(String userId){
        System.out.println("execute to query..."+userId);
        return new User();
    }
    public void reload(){
        cacheManager.clearCache();
    }
}
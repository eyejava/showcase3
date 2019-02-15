package com.jade.showcase.user.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jade.showcase.user.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jade
 * @since 2019-01-29
 */
public interface IUserService extends IService<User> {

   // @Cached(expire = 3600, cacheType = CacheType.REMOTE)
    @RequestMapping("getUserByCache")
    @CacheInvalidate(name="userCache-", key="args[0]")
    public  User getUserByCache(Integer userId);



}

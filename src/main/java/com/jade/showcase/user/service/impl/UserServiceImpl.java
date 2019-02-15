package com.jade.showcase.user.service.impl;

import com.jade.showcase.user.entity.User;
import com.jade.showcase.user.mapper.UserMapper;
import com.jade.showcase.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jade
 * @since 2019-01-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    public  void findById(){
        this.getById(100);

    }


    @Override
    public User getUserByCache(Integer userId) {
        return this.getById(userId);
    }
}

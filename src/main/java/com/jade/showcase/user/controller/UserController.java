package com.jade.showcase.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jade.showcase.common.BaseController;
import com.jade.showcase.user.entity.User;
import com.jade.showcase.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jade
 * @since 2019-01-29
 */
@RestController
@RequestMapping("/user/user")
public class UserController extends BaseController {
    @Autowired
    IUserService userService;

    @RequestMapping("getUsername")
    public String getUsername() {
        return "jade";
    }


    @RequestMapping("getUsernameByDB")
    public String getUsernameByDB() {
        User user = userService.getById(100);
        List<User> list = userService.list();
        List<Map<String, Object>> map = userService.listMaps();
        Wrapper<User> query = new Wrapper<User>() {
            @Override
            public User getEntity() {
                return null;
            }

            @Override
            public MergeSegments getExpression() {
                return null;
            }

            @Override
            public String getCustomSqlSegment() {
                return null;
            }

            @Override
            public String getSqlSegment() {
                return null;
            }
        };
        userService.list(query);
        IPage<User> page = new Page();
        page.setSize(3);
        page.setCurrent(1);
        IPage<User> userList = userService.lambdaQuery().page(page);
        List<User> records = userList.getRecords();
        System.out.println(records.size());
        System.out.println(records.get(0).toString());
        User newUser =  new User();
        newUser.setName("mybatis plus");
        newUser.setAge(123);
//        newUser.setId(1000);
        userService.save(newUser);

        return newUser.getId().toString();
    }


}

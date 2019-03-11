package com.jade.showcase.eat.youbb.controller;


import com.jade.showcase.common.BaseController;
import com.jade.showcase.crawler.utils.YbbEatCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jade
 * @since 2019-03-07
 */
@RestController
@RequestMapping("/youbb")
public class YbbCanEatController extends BaseController {

    @Autowired
    YbbEatCrawler ybbEatCrawler;

    @RequestMapping("add")
    public void add(){
        ybbEatCrawler.crawler();

    }
}

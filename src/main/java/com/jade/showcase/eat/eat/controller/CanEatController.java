package com.jade.showcase.eat.eat.controller;


import com.jade.showcase.common.BaseController;
import com.jade.showcase.crawler.utils.MamabangCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jade
 * @since 2019-03-06
 */
@RestController
@RequestMapping("/caneat")
public class CanEatController extends BaseController {

    @Autowired
    MamabangCrawler mamabangCrawler;

@RequestMapping("add")
    public void add(){
    mamabangCrawler.crawler();
    }

}

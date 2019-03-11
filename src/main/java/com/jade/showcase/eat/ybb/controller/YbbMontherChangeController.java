package com.jade.showcase.eat.ybb.controller;


import com.jade.showcase.common.BaseController;
import com.jade.showcase.crawler.utils.YoubaobaoCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jade
 * @since 2019-03-07
 */
@RestController
@RequestMapping("/ybb")
public class YbbMontherChangeController extends BaseController {

    @Autowired
    YoubaobaoCrawler youbaobaoCrawler;

    @RequestMapping("add")
    public void add() {
        youbaobaoCrawler.crawler();

    }

}

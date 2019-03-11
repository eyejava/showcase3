package com.jade.showcase.demo.change.controller;


import com.jade.showcase.common.BaseController;
import com.jade.showcase.crawler.utils.MontherChangeMmbCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jade
 * @since 2019-03-11
 */
@RestController
@RequestMapping("/mmb-monther-change")
public class MmbMontherChangeController extends BaseController {


    @Autowired
    MontherChangeMmbCrawler montherChangeMmbCrawler;

    @RequestMapping("add")
    public void add(){
        montherChangeMmbCrawler.crawler();
    }

}

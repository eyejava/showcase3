package com.jade.showcase.demo.change.controller;


import com.jade.showcase.common.BaseController;
import com.jade.showcase.crawler.utils.MontherChangeMmbCrawler;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;

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
    public void add() throws  Exception{
        String templatePath = URLDecoder
                .decode(Thread.currentThread().getContextClassLoader()
                        .getResource("").getPath(), "utf-8")
                + "download/order.xls";
        File templateFile = new File(templatePath);
        InputStream in = new FileInputStream(templateFile);
        byte[] buf = IOUtils.toByteArray(in);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buf);
        HSSFWorkbook workbook = new HSSFWorkbook(byteArrayInputStream);
        workbook.getName("test");
        System.out.println(workbook);
     //   montherChangeMmbCrawler.crawler();
    }

}

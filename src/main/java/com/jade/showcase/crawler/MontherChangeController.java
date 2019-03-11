package com.jade.showcase.crawler;

import com.jade.showcase.crawler.entity.MontherChangeLong;
import com.jade.showcase.crawler.service.MontherChangeService;
import com.jade.showcase.crawler.utils.Crawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/montherchange")
public class MontherChangeController {

    @Autowired
    MontherChangeService montherChangeService;

    @RequestMapping("addMontherChange")
    public void addMontherChange(){

        Crawler crawler =new Crawler();
        String url= "https://knowledge.babytreeimg.com/knowledge/detail/1041";
        String content = crawler.doGet(url);
        //   System.out.println(content);

        // Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

        Document doc = Jsoup.parse(content);
        //Element element = doc.select("gestate-text");
        Element body = doc.body();
        String myContent = body.text();
        System.out.println("------");
        System.out.println(myContent);

        MontherChangeLong change = new MontherChangeLong();
        change.setContent(myContent);
        montherChangeService.save(change);
    }
}

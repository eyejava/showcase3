package com.jade.showcase.crawler.utils;

import com.alibaba.fastjson.JSONObject;
import com.jade.showcase.eat.ybb.entity.YbbMontherChange;
import com.jade.showcase.eat.ybb.service.IYbbMontherChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YoubaobaoCrawler {


    @Autowired
    IYbbMontherChangeService ybbMontherChangeService;

    public static void main(String[] args) {

    }

    public void crawler() {

        int week = 0;


        for (week = 0; week < 43; week++) {
            String url = "https://ybb.seeyouyima.com/v2/gestation_change_detail?type=1&device_id=863409032085374&week=" + week;
            crawlerChange(url,week);

        }


    }

    private void crawlerChange(String url,int week) {
        String response = Crawler.doGet(url);

        JSONObject jsonObject = JSONObject.parseObject(response);

        JSONObject monther = jsonObject.getJSONObject("data").getJSONObject("mother");
        String content = monther.get("content").toString();
        String phyChange = monther.get("phy_change").toString();

        String sym_change = monther.get("sym_change").toString();
        String psy_change = monther.get("psy_change").toString();
        String prm_change = monther.get("prm_change").toString();
        String body_change = monther.get("body_change").toString();
        String mom_article = jsonObject.getJSONObject("data").get("mom_article").toString();


        YbbMontherChange change = new YbbMontherChange();

        change.setContent(content);
        change.setMomArticle(mom_article);
        change.setPhyChange(phyChange);
        change.setPrmChange(prm_change);
        change.setBodyChange(body_change);
        change.setPsyChange(psy_change);
        change.setSymChange(sym_change);

        change.setId(week);
        System.out.println(content);
        ybbMontherChangeService.save(change);
    }
}

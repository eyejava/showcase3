package com.jade.showcase.crawler.utils;

import com.alibaba.fastjson.JSONObject;
import com.jade.showcase.eat.youbb.entity.YbbCanEat;
import com.jade.showcase.eat.youbb.service.IYbbCanEatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YbbEatCrawler {

    @Autowired
    IYbbCanEatService ybbCanEatService;

    public static void main(String[] args) {

    }
    public  void crawler() {

        int id = 1;
        for (id = 1;id< 2000;id++){

            crawlerItem(id);
        }




    }

    private void crawlerItem(int id) {
        String url ="http://tools-node.seeyouyima.com/data-api/taboo/food?authorization=&id="+id;
        String response = Crawler.doGet(url);

        if (StringUtils.isEmpty(response)){
           return;
        }
        JSONObject data = JSONObject.parseObject(response);

        YbbCanEat eat = new YbbCanEat();

        eat.setId(Integer.parseInt(data.get("id").toString()));
        eat.setBabyComment(data.get("baby_comment").toString());
        eat.setBabyNotice(data.get("baby_notice").toString());
        eat.setCategory(data.get("category").toString());
        eat.setFriendlyTips(data.get("friendly_tips").toString());
        eat.setIcon(data.get("icon").toString());
        eat.setImg(data.get("img").toString());
        eat.setLactationComment(data.get("lactation_comment").toString());
        eat.setNutrition(data.get("nutrition").toString());
        eat.setLactationNotice(data.get("lactation_notice").toString());
        eat.setPregnantComment(data.get("puerpera_comment").toString());
        eat.setSort(data.get("sort").toString());
        eat.setPuerperaNotice(data.get("puerpera_notice").toString());
        eat.setFriendlyTips(data.get("friendly_tips").toString());
        eat.setTabooIngredient(data.get("taboo_ingredient").toString());
        eat.setStrategy(data.get("strategy").toString());
        eat.setTitleAlias(data.get("title_alias").toString());
        eat.setTitle(data.get("title").toString());

        eat.setId(id);
        ybbCanEatService.save(eat);
    }


}

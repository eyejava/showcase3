package com.jade.showcase.crawler.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jade.showcase.demo.change.entity.MmbMontherChange;
import com.jade.showcase.demo.change.service.IMmbMontherChangeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MontherChangeMmbCrawler {

    @Autowired
    IMmbMontherChangeService mmbMontherChangeService;

    public  void crawler() {

        String url = "https://mobile.mmbang.com/api/home/mobile/v1/momchange?api_version=5.1.6&app_client_id=1&carrier_code=&channel=AppStore&device=iPad6%2C11&device_id=777174f0008002f0e26f8ef811191601eea757fc&idfa=17C8173D-6C7A-481B-8FBD-17C53010CE96&lat=31.2971649&lon=120.5705643&network=0&openudid=777174f0008002f0e26f8ef811191601eea757fc&os_version=12.1.4&resolution=1536%2A2048&role=2&screen_size=l&sid=3447914081&sign=3197e43fa976e1359c0cef25d0e60b9a&silent=1&skey=35295467&time=1552289555.854596";


        String content = "";
        String newUrl = "";

        for (int i = 2; i < 42; i++) {
            newUrl = url + "&period=" + i;
            content = Crawler.doGet(newUrl);


            if (StringUtils.isNotEmpty(content)) {
                System.out.println(content);
                JSONObject data = JSONObject.parseObject(content);
                JSONArray items = data.getJSONObject("data").getJSONArray("items");
                JSONObject contentFirst = (JSONObject) items.get(0);
                System.out.println(contentFirst.get("content").toString());
                JSONObject contentSecond = (JSONObject) items.get(1);
                System.out.println(contentSecond.get("content").toString());
                JSONObject contentThird = (JSONObject) items.get(2);
                System.out.println(contentThird.get("content").toString());

                MmbMontherChange change = new MmbMontherChange();

                change.setWeek(i);
                change.setMontherChange(contentFirst.get("content").toString());
                change.setNutritionGuide(contentSecond.get("content").toString());

                change.setAttention(contentThird.get("content").toString());

                mmbMontherChangeService.save(change);

            }

        }

    }
}

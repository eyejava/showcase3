package com.jade.showcase.crawler.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jade.showcase.eat.eat.entity.CanEat;
import com.jade.showcase.eat.eat.service.ICanEatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class MamabangCrawler {

    @Autowired
    ICanEatService canEatService;

    public static void main(String[] args) {
     //   crawler();
    }

    public  void crawler() {
        // "https://www.baidu.com";

        int category = 1;
        Integer page = 1;

        for (category = 1; category < 17; category++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (category == 10){
                continue;
            }
            for (page = 1; page < 20; page++) {

                String url = "https://www.mmbang.com/api/v2/content/food/list?canUse=9999&crowd=9999&keyword=&pageSize=20&mmbDevVersion=env3&category=" + category + "&page=" + page.toString();
                String content = Crawler.doGet(url);

                JSONObject jsonObject = JSONObject.parseObject(content);
                JSONObject temp = jsonObject.getJSONObject("data");

                System.out.println(content);
                JSONArray array = temp.getJSONArray("items");
                if(array.isEmpty()){
                    break;
                }
                for (Iterator iterator = array.iterator(); iterator.hasNext();) {
                    JSONObject item = (JSONObject) iterator.next();


                    System.out.println("=========== features " + item.get("features").toString());
                    System.out.println("-------------- buytips " + item.get("buyTips").toString());

                    CanEat canEat = new CanEat();

                    canEat.setFeatures(item.get("features").toString());
                    canEat.setBuyTips(item.get("buyTips").toString());
                    canEat.setUseTips(item.get("useTips").toString());
                    try {
                        canEat.setPicUrl(item.getJSONObject("pic").get("url").toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    canEat.setAlias(item.get("alias").toString());
                    canEat.setTitle(item.get("title").toString());
                    canEat.setCat(item.get("cat").toString());
                    canEat.setCatTitle(item.get("catTitle").toString());
                    canEat.setId(Integer.parseInt(item.get("id").toString()));

                    JSONArray props = item.getJSONArray("proposal");

                    JSONObject proposal = (JSONObject) props.get(0);

                    canEat.setKeyInfo(proposal.get("key").toString());
                    canEat.setProposalTitle(proposal.get("title").toString());
                    canEat.setCanUse(Integer.parseInt(proposal.get("canUse").toString()));
                    canEat.setContent(proposal.get("content").toString());
                    canEat.setBabyStage(proposal.get("babyStage").toString());


                    JSONObject secondProposal = (JSONObject) props.get(1);

                    canEat.setCfKey(secondProposal.get("key").toString());
                    canEat.setCfProposalTitle(secondProposal.get("title").toString());
                    canEat.setCfCanUse(Integer.parseInt(secondProposal.get("canUse").toString()));
                    canEat.setCfContent(secondProposal.get("content").toString());
                    canEat.setCfBabyStage(secondProposal.get("babyStage").toString());


                    JSONObject thirdProposal = (JSONObject) props.get(2);

                    canEat.setBrqKey(thirdProposal.get("key").toString());
                    canEat.setBrqProposalTitle(thirdProposal.get("title").toString());
                    canEat.setBrqCanUse(Integer.parseInt(thirdProposal.get("canUse").toString()));
                    canEat.setBrqContent(thirdProposal.get("content").toString());
                    canEat.setBrqBabyStage(thirdProposal.get("babyStage").toString());



                    JSONObject fourProposal = (JSONObject) props.get(3);

                    canEat.setBbKey(fourProposal.get("key").toString());
                    canEat.setBbProposalTitle(fourProposal.get("title").toString());
                    canEat.setBbCanUse(Integer.parseInt(fourProposal.get("canUse").toString()));
                    canEat.setBbContent(fourProposal.get("content").toString());
                    canEat.setBbBabyStage(fourProposal.get("babyStage").toString());


                    canEatService.save(canEat);
                    }
                }


        }
        }


}

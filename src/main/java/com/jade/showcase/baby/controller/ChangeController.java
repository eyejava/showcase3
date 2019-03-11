package com.jade.showcase.baby.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jade.showcase.baby.entity.Change;
import com.jade.showcase.baby.service.IChangeService;
import com.jade.showcase.common.BaseController;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jade
 * @since 2019-03-05
 */
@RestController
@RequestMapping("/baby/change")
public class ChangeController extends BaseController {

    @Autowired
    IChangeService changeService;

    @RequestMapping("add")
    public  void addChange(){
        String path ="D:\\开发\\app破解\\local_baby_tips.json";
        String input = null;
        try {
            input = FileUtils.readFileToString(new File(path), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(input);
        JSONObject temp = jsonObject.getJSONObject("data");
    //    JSONArray jsonArray = jsonObject.getJSONArray("data");
    //    JSONArray data  = jsonObject.getJSONArray("data");

        JSONArray array = temp.getJSONArray("baby-unborn");

     //   array.getJSONObject(0);
        for (Iterator iterator = array.iterator(); iterator.hasNext();) {
            JSONObject job = (JSONObject) iterator.next();
        //    System.out.println(job.get("description").toString());
         //   System.out.println(job.get("week").toString());
            JSONArray boy_tips = job.getJSONArray("boy_tips");
//            System.out.println(boy_tips.get(0));
//            System.out.println(boy_tips.get(1));

            JSONArray girl_tips = job.getJSONArray("girl_tips");

            JSONArray tips = job.getJSONArray("tips");

           // System.out.println(girl_tips.get(0));
           // System.out.println(girl_tips.get(1));


            Change change = new Change();

            change.setBabyInfo(job.get("baby_info").toString());
            change.setDay(Integer.parseInt(job.get("day").toString()));
            change.setDescription(job.get("description").toString());
      //      change.setGirlheight(girl_tips.get(1).toString());
    //        change.setGirlweight(girl_tips.get(0).toString());

            change.setHeight(tips.get(1).toString());
            change.setWeight(tips.get(0).toString());
            change.setWeek(Integer.parseInt(job.get("week").toString()));

            change.setMotherDesc(job.get("mother_desc").toString());
            System.out.println(job.get("mother_desc").toString());

            changeService.save(change);
        }


   //     System.out.println(data.gets);  getJSONObject("baby-1-x")
     //   data.getJSONArray()

    }



}

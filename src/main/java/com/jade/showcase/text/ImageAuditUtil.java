package com.jade.showcase.text;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.util.Base64Util;
import com.jade.showcase.text.config.BaiDuAuthConfig;
import com.jade.showcase.utils.HttpUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageAuditUtil {

    public static void main(String[] args) throws IOException {
        Map<String, Object> input = new HashMap<String, Object>();
        List<Object> scenes = new ArrayList<Object>();
//        scenes.add("ocr");
//        scenes.add("face");
//        scenes.add("public");
//        scenes.add("politician");
        scenes.add("antiporn");
//        scenes.add("terror");
//        scenes.add("webimage");
//        scenes.add("disgust");
//        scenes.add("watermark");

      //  String filePath = "D:\\测试图片\\seqing.jpg";
        String filePath = "D:\\测试图片\\3.jpg";

        byte[] imgData = FileUtils.readFileToByteArray(new File(filePath));
        String imgStr = Base64Util.encode(imgData);

        String access_token = BaiDuAuthConfig.getAuth();
        //添加调用参数
      //  input.put("access_token", access_token);

        input.put("image", imgStr);//与image二者选一
        input.put("scenes", scenes);

        String jsonStr = JSON.toJSONString(input);
        System.out.println(jsonStr);
        String result = HttpUtil.doPostJson(BaiDuAuthConfig.IMG_CENSOR_URL+"?access_token="+access_token, jsonStr);
        System.out.println(result);
        System.out.println(result);

    }
}

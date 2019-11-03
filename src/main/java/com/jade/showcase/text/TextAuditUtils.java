package com.jade.showcase.text;

import com.jade.showcase.text.config.BaiDuAuthConfig;
import com.jade.showcase.text.model.CheckTextResult;
import com.jade.showcase.text.model.Pass;
import com.jade.showcase.text.model.Result;
import com.jade.showcase.utils.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class TextAuditUtils {

    public static void main(String[] args) {
        String access_token = BaiDuAuthConfig.getAuth();
        Map<String, String> parameters = new HashMap<>();
        //添加调用参数
        parameters.put("access_token", access_token);
      //  String detail = "过了一会，刘豪撸下一点白洁上身的裙口，看她露出软柔的部分，刘豪意乱神迷的吸了上去。再过了一会，白洁也呼吸有些加促，她的手忍不住轻轻握住了刘豪的那东西。随着轻抚的动作，白洁的身上裙子被褪了下来。";
        String detail ="反动言论";
        parameters.put("content", detail);
        //调用文本审核接口
        String result = HttpUtil.doPost(BaiDuAuthConfig.WORD_CHECK_URL, parameters);
        // JSON转换
        net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(result);
        Map<String, Class> classMap = new HashMap<String, Class>();
        classMap.put("result", Result.class);
        classMap.put("pass", Pass.class);
        classMap.put("bass", CheckTextResult.class);
        CheckTextResult bean = (CheckTextResult) net.sf.json.JSONObject.toBean(jsonObj, CheckTextResult.class, classMap);

        if ((bean.getResult().getReject().size() + bean.getResult().getReview().size() > 0)) {
            System.out.println(bean.getResult().getReject());
            System.out.println(bean.getResult().getReview());
            System.out.println("================= no pass ==============================");
        }else{
            System.out.println(bean.getResult().getPass());
        }
    }
}

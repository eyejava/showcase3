package com.jade.showcase.text;

import com.baidu.aip.contentcensor.AipContentCensor;
import org.json.JSONObject;

public class ImageAuditUtils {
    //设置APPID/AK/SK
    public static final String APP_ID = "17711901";
    public static final String API_KEY = "ck3kG8YvjKZZ8wSSzmt6kuNX";
    public static final String SECRET_KEY = "EryYoDGyKsru97G8t7yA9ZAqGfoVCS4j";

    public static void main(String[] args) {
        // 初始化一个AipContentCensor
        AipContentCensor client = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        String path = "D:\\测试图片\\seqing.jpg";
        //  String path = "D:\\测试图片\\test.jpg";
        JSONObject res = client.antiTerror(path);

        System.out.println(res.toString(2));

        System.out.println("-------------------");

    }
}
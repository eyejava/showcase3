package com.jade.showcase.crawler.utils;

import com.jade.showcase.crawler.entity.MontherChangeLong;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

public class Crawler {

    public static String doGet(String url, Map<String, String> param) {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();


        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D57 mmbang/5.1.6 NetType/UNKNOWN /sa-sdk-ios";
            httpGet.setHeader("User-Agent",userAgent);

            httpGet.setHeader("Referer", "https://mobile.mmbang.com");
            httpGet.setHeader("Origin","https://mobile.mmbang.com");
            httpGet.setHeader("Accept","application/json, text/plain, */*");

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public static String doGet(String url) {
        return doGet(url, null);
    }

    public static void main(String[] args) {
    String url= "https://mobile.mmbang.com/api/home/mobile/v1/momchange?api_version=5.1.6&app_client_id=1&carrier_code=&channel=AppStore&device=iPad6%2C11&device_id=777174f0008002f0e26f8ef811191601eea757fc&idfa=17C8173D-6C7A-481B-8FBD-17C53010CE96&lat=31.2971649&lon=120.5705643&network=0&openudid=777174f0008002f0e26f8ef811191601eea757fc&os_version=12.1.4&period=5&resolution=1536%2A2048&role=2&screen_size=l&sid=3447914081&sign=3197e43fa976e1359c0cef25d0e60b9a&silent=1&skey=35295467&time=1552289555.854596";
        String content = doGet(url);
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
    //    montherChangeLongMapper.insert(montherLong);
        System.out.println("====================");

    }
}

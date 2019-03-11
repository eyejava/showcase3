package com.jade.showcase.crawler.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CmdCrawler {

    public static void main(String[] args) throws Exception {

        String command = "D:\\soft\\curl-7.64.0_2-win64-mingw\\curl-7.64.0-win64-mingw\\bin\\curl.exe -H 'Host: mobile.mmbang.com' -H 'Accept: application/json' -H 'Cookie: sid=3447914081;uid=22323777;' -H 'X-SD-Log: eyJzZF9kaXN0aW5jdF9pZCI6IjIyMzIzNzc3IiwiJG9zX3ZlcnNpb24iOiIxMi4xLjQiLCIkZGV2aWNlX2lkIjoiQzkzQjkzNEEtNTRBNS00QjBFLTk1NDctMUM1MjUxNEJDQjA3IiwiJG9zIjoiaU9TIiwiJHNjcmVlbl9oZWlnaHQiOjY2NywiJGlzX2ZpcnN0X2RheSI6ZmFsc2UsIiRzY3JlZW5fd2lkdGgiOjM3NSwiJG1vZGVsIjoiaVBhZDYsMTEiLCIkd2lmaSI6dHJ1ZSwiJG5ldHdvcmtfdHlwZSI6IldJRkkiLCIkYXBwX3ZlcnNpb24iOiI1LjEuNiIsIiRtYW51ZmFjdHVyZXIiOiJBcHBsZSIsIiRsaWIiOiJpT1MiLCIkbGliX3ZlcnNpb24iOiIxLjEwLjkifQ==' -H 'User-Agent: Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D57 mmbang/5.1.6 NetType/UNKNOWN /sa-sdk-ios' -H 'Accept-Language: zh-Hans-CN;q=1' --compressed 'https://mobile.mmbang.com/api/home/mobile/v1/momchange?api_version=5.1.6&app_client_id=1&carrier_code=&channel=AppStore&device=iPad6%2C11&device_id=777174f0008002f0e26f8ef811191601eea757fc&idfa=17C8173D-6C7A-481B-8FBD-17C53010CE96&lat=31.2971649&lon=120.5705643&network=0&openudid=777174f0008002f0e26f8ef811191601eea757fc&os_version=12.1.4&resolution=1536%2A2048&role=2&screen_size=l&sid=3447914081&sign=4c6d5fed5944ee89e31b698b6622d8c2&silent=1&skey=35295467&time=1552291186.139872";
        command = command + "&period=9'";


        Process p = Runtime.getRuntime().exec(command);

        // ##读取命令的输出信息
        InputStream is = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        p.waitFor();
        if (p.exitValue() != 0) {
            //说明命令执行失败
            //可以进入到错误处理步骤中
        }

        //##打印输出信息
        String s = null;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }

    }
}

package com.jade.showcase.text;

import com.baidu.aip.contentcensor.AipContentCensor;
import com.baidu.aip.contentcensor.EImgType;
import org.json.JSONObject;

public class ContentAuditUtils {
    //设置APPID/AK/SK
    public static final String APP_ID = "17711901";
    public static final String API_KEY = "ck3kG8YvjKZZ8wSSzmt6kuNX";
    public static final String SECRET_KEY = "EryYoDGyKsru97G8t7yA9ZAqGfoVCS4j";


    private static AipContentCensor client;

    public static AipContentCensor getInstance() {

        if (client == null) {
            synchronized (ContentAuditUtils.class) {
                // 初始化一个AipContentCensor
                client = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);
                // 可选：设置网络连接参数
                client.setConnectionTimeoutInMillis(2000);
                client.setSocketTimeoutInMillis(60000);
            }
        }

        return client;
    }

    public static void main(String[] args) {

        // 调用接口
        String path = "D:\\测试图片\\20180928155329466.png";
        path ="http://hmm-public.oss-cn-beijing.aliyuncs.com/hmm-user-test/images/0dfbe469-fb6d-4016-8573-00d2792a9a49.9j";
        if (client == null) {
            client = getInstance();
        }
        boolean resp = auditImg(path,ContentType.URL);
        System.out.println(resp);
/*
        resp = false;
        resp = auditText("打倒共产党");
        System.out.println(resp);*/
    }

    /**
     * 图片审核
     *
     * @param path
     * @param type
     * @return
     */
    public static boolean auditImg(String path, ContentType type) {
        JSONObject response = new JSONObject();
        if (client == null) {
            client = getInstance();
        }
        if (type.equals(ContentType.FILE)) {
            response = client.imageCensorUserDefined(path, EImgType.FILE, null);
        } else {
            response = client.imageCensorUserDefined(path, EImgType.URL, null);
        }
        String conclusionType = response.get("conclusionType").toString();
        return "1".equals(conclusionType);
    }

    /**
     * @param text
     * @return
     */
    public static boolean auditText(String text) {
        if (client == null) {
            client = getInstance();
        }
        JSONObject response = client.textCensorUserDefined(text);
        String conclusionType = response.get("conclusionType").toString();
        return "1".equals(conclusionType);
    }

    public enum ContentType {
        FILE,
        URL;

        private ContentType() {
        }
    }
}
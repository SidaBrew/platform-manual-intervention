package com.zenki.dataplus.pmi.sendmsg;

import com.alibaba.fastjson.JSON;
import com.zenki.dataplus.pmi.sendmsg.CheckSumBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * FileName: SendMessage
 * Author:   luolei
 * Date:     2020/8/18 15:23
 * Description:
 * History:
 */
public class SendMessage {

    // 发送验证码的请求路径URL
    private static final String SERVER_URL = "https://api.netease.im/sms/sendcode.action";
    // 网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    private static final String APP_KEY = "0a14f3d45f2000252264b4ad4ab38ae6";
    // 网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    private static final String APP_SECRET = "1ff941bbeede";
    // 随机数
    private static final String NONCE = "123456";
    // 短信模板ID
    private static final String TEMPLATEID = "14811005";
    // 手机号
//     private static final String MOBILE="17610170622";
// 验证码长度，范围4～10，默认为4
    private static final String CODELEN = "6";

    public static String SendCode(String phone) throws ClientProtocolException, IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(SERVER_URL);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        /*
         * 参考计算CheckSum的java代码.
         */
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);
// 设置请求的header
        httpPost.addHeader("AppKey", APP_KEY);
        httpPost.addHeader("Nonce", NONCE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
// 设置请求的的参数，requestBody参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

/** 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档”
 * 2.参数格式是 jsonArray的格式，例如
 * "['13888888888','13666666666']"
 * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
 */
        nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
        nvps.add(new BasicNameValuePair("mobile", phone));
        nvps.add(new BasicNameValuePair("codeLen", CODELEN));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
// 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        /*
         * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500
         * 2.具体的code有问题的可以参考官网的Code状态表
         */
        String jsonCode = EntityUtils.toString(response.getEntity(), "utf-8");
//jsoncode是一个json串，例如{"code":200,"msg":"5","obj":"251288"}
        //返回状态码
        String code = JSON.parseObject(jsonCode).getString("code");
        return code;
    }

    public static void main(String[] args) throws ClientProtocolException, IOException {
        String phone = "17610170622";
        String code = SendCode(phone);
        if (code.equals("200")) {
            System.out.println("发送成功");
        } else {
            System.out.println("发送失败");
        }
    }
}

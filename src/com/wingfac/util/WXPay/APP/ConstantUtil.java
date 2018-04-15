package com.wingfac.util.WXPay.APP;

import com.wingfac.util.Constants;

public class ConstantUtil {
    /**
     * 微信开发平台应用ID
     */
    public static final String APP_ID="wx8d939e7aa2822024";
    /**
     * 应用对应的凭证
     */
    public static final String APP_SECRET="9ce5c0de5eabbd6d3737f4a773b87162";
    /**
     * 应用对应的密钥
     */
    public static final String APP_KEY="9ce5c0de5eabbd6d3737f4a773b87162";
    /**
     * 微信支付商户号
     */
    public static final String MCH_ID="1498909912";
    /**
     * 商品描述
     */
    public static final String BODY="空调金管家-付款";
    /**
     * 商户号对应的密钥
     */
    public static final String PARTNER_key="226fbe49696b85f2d85204b7567a46db";
    
    /**
     * 商户id
     */
    public static final String PARTNER_ID="1498909912";
    /**
     * 常量固定值
     */
    public static final String GRANT_TYPE="client_credential";
    /**
     * 获取预支付id的接口url
     */
    public static String GATEURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 微信服务器回调通知url
     */
//    public static String NOTIFY_URL="https://pay.weixin.qq.com/wxpay/pay.action";
//    public static String NOTIFY_URL="http://192.168.1.138:9510/PayAtTheShop/pay/notify_app.action";

    public static String NOTIFY_URL=Constants.WXNotifyUrl;
}

package com.wingfac.util.WXutil;

import com.github.wxpay.sdk.WXPayConfig;
import com.wingfac.util.ThiredInfo;

import java.io.InputStream;

public class WXPayConfigImpl implements WXPayConfig {

	private static WXPayConfigImpl INSTANCE;

    public static WXPayConfigImpl getInstance() throws Exception{
        if (INSTANCE == null) {
            synchronized (WXPayConfigImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WXPayConfigImpl();
                }
            }
        }
        return INSTANCE;
    }

	/**
	 * 作者:WZD
	 * 2017年8月16日 上午9:04:21
	 * 获取appId
	 */
	@Override
	public String getAppID() {
		return ThiredInfo.WXAppid;
	}

	/**
	 * 作者:WZD
	 * 2017年8月16日 上午9:04:21
	 * 获取证书内容
	 */
	@Override
	public InputStream getCertStream() {
		return null;
	}

	/**
	 * 作者:WZD
	 * 2017年8月16日 上午9:04:21
	 * 设置请求超时时间
	 */
	@Override
	public int getHttpConnectTimeoutMs() {
		return 600000;
	}

	/**
	 * 作者:WZD
	 * 2017年8月16日 上午9:04:21
	 * 读取时间
	 */
	@Override
	public int getHttpReadTimeoutMs() {
		return 600000;
	}

	/**
	 * 作者:WZD
	 * 2017年8月16日 上午9:04:21
	 * apiKey
	 */
	@Override
	public String getKey() {
		return ThiredInfo.WXApiKey;
	}

	/**
	 * 作者:WZD
	 * 2017年8月16日 上午9:04:21
	 * 商户号
	 */
	@Override
	public String getMchID() {
		return ThiredInfo.WXMchid;
	}



}

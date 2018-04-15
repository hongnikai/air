package com.wingfac.util.Alipay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.wingfac.util.Constants;

/**
 ** @author MengJinyue   
 *  创建时间：2018-1-11 下午04:38:18 
 */
public class AlipayOrderQuery {
	public static JSONObject query(HttpServletRequest req,HttpServletResponse res,String out_trade_no) throws AlipayApiException {
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",Constants.ALPayAppId,
				Constants.ALAppPrivateKey,"json","GBK",Constants.ALPublicKey,"RSA2");
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		request.setBizContent("{" +
				"\"out_trade_no\":\""+out_trade_no+"\"" +
				"}");
		AlipayTradeQueryResponse response = alipayClient.execute(request);
		if(response.isSuccess()){
			String body = response.getBody();
			JSONObject json = JSONObject.fromObject(body);
			System.out.println(body);
			System.out.println("调用成功");
			return json;
		} else {
			System.out.println("调用失败");
			return null;
		}
		
	}
}

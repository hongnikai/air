package com.wingfac.util.address;

/**
 ** @author MengJinyue   
 *  创建时间：2017-9-1 下午03:26:31 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import sun.misc.BASE64Encoder;

/**
 * google地图得地址详情
 * 
 * @author admin
 * 
 */
public class GetLocationMsg {

	public final static void main(String[] args) {

		/*
		 * //String jsonStr = GetLocationMs(22.329157, 114.203258); JSONObject
		 * jsonObj = JSONArray.parseObject(jsonStr); JSONArray jsonArray =
		 * (JSONArray) jsonObj.get("results"); System.out.println(jsonArray);
		 * List list = new ArrayList();// 用list保存全部数据 for (int i = 0; i <
		 * jsonArray.size(); i++) { Userdetails user = (Userdetails)
		 * JSONObject.toJavaObject(jsonArray.getJSONObject(i),
		 * Userdetails.class); // System.out.println(user.toString());
		 * list.add(user.getFormatted_address()); } System.out.println(list);
		 */
	}

	public static String GetLocationMs(double d, double f) {

		String message = "";

		String url = String.format(

		"http://ditu.google.cn/maps/api/geocode/json?latlng=%s,%s&language=CN",

		d, f);

		URL myURL = null;

		URLConnection httpsConn = null;

		try {

			myURL = new URL(url);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

		try {

			httpsConn = (URLConnection) myURL.openConnection();

			if (httpsConn != null) {

				InputStreamReader insr = new InputStreamReader(

				httpsConn.getInputStream(), "UTF-8");

				BufferedReader br = new BufferedReader(insr);

				String data = null;

				while ((data = br.readLine()) != null) {

					message = message + data;

				}

				insr.close();

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

		return message;

	}

	public static String GetBaiduLocation(double d, double f)
			throws MalformedURLException, IOException {
		String message = "";

		String url = "http://api.map.baidu.com/geocoder/v2/?ak=YMS8iVxYOGuKV0AoVfmGGsXGt8iDiSOL&callback=renderReverse&location="
				+ d + "," + f + "&output=json&pois=1";

		URL myURL = null;

		URLConnection httpsConn = null;

		try {

			myURL = new URL(url);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

		try {

			httpsConn = (URLConnection) myURL.openConnection();

			if (httpsConn != null) {

				InputStreamReader insr = new InputStreamReader(

				httpsConn.getInputStream(), "UTF-8");

				BufferedReader br = new BufferedReader(insr);

				String data = null;

				while ((data = br.readLine()) != null) {

					message = message + data;

				}

				insr.close();

			}
			
		} catch (IOException e) {

			e.printStackTrace();

		}

		return message;
	}

	/**
	 * 解码
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

}

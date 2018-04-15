package com.wingfac.util;

import java.text.SimpleDateFormat;
/**
 *  @描述：获取系统时间
 *  @author LC   (●'◡'●)  lc
 *  创建时间：2018-3-2 上午9:35
 */
public class TimeUtil {

	public String getSystemTimeFormart(){
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String eva_time = simple.format(System.currentTimeMillis());
		
		return eva_time;
	}
	
	public static void main(String[] args) {
		TimeUtil time = new TimeUtil();
		System.out.println(time.getSystemTimeFormart());
	}
	
	/**
	 *  @描述：
	 *  @return long类型当前系统时间  
	 */
	public static long timeMath(){
		return System.currentTimeMillis();
	}
	
}

package Test;

import java.util.Random;

import com.wingfac.util.MD5Util;
import com.wingfac.util.TenpayUtil;
import com.wingfac.util.lcRamdomUtil;

/**
 * 计算器
 */
public class sysdy {
public static void main(String[] args) {
	
	/*int a=10;
	int b=10;
	System.out.println(3/5!=0);
	
	System.out.println(5*(0-1));	
	*/
	/*//String currTime = TenpayUtil.getCurrTime();
	//8位日期
	//String strTime = currTime.substring(8, currTime.length());
	//四位随机数
	//String strRandom = TenpayUtil.buildRandom(4) + "";
	//10位序列号,可以自行调整。
	//String strReq = strTime + strRandom;
	lcRamdomUtil lc=new lcRamdomUtil();
	Long currTime=System.currentTimeMillis();
	String c=currTime.toString();
	
	String strReq=(c+lc.getRamdomString());
	*/
	String a="0";
	String[] asd="0".split(",");
	for (int i = 0; i < asd.length; i++) {
		System.out.println(asd[i]);
	}
	
	
}
}

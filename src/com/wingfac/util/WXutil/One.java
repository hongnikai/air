package com.wingfac.util.WXutil;

/**
 * User: WZD
 * Date: 2018/1/2
 * Time: 11:48
 */
public class One {
    static int x = 5;
    static {
        System.out.println("fist:" + x);
        x-=5;
        System.out.println("frist:" + x);
    }
      {
          System.out.println("块:" + x);
          x += 10;
          System.out.println(x);
      }
    public static void main(String[] args){
        System.out.println("third:"+x);
        System.out.println("----------");
        One one = new One();
    }
    static {
        x-=5;
        System.out.println("second:" + x); }
}

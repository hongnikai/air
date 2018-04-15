package com.wingfac.entity;
/**
 *  @描述:返回销量排序商品信息
 ** @author lc 
 *  创建时间：2017-02-27 下午02:26:12 
 */
public class CommoditySaleCounts_resultBean {
	/**
	 * 
	 */
	private String c_name;
	private String c_id;
	private String price;
	private int counts;
	private String cover_picture;
	public String getCover_picture() {
		return cover_picture;
	}
	public void setCover_picture(String cover_picture) {
		this.cover_picture = cover_picture;
	}
	/**
	 * 
	 */
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	
	
}

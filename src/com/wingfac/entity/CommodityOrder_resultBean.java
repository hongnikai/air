package com.wingfac.entity;
/**
 *  @描述:返回订单详情信息
 ** @author lc 
 *  创建时间：2017-02-08 下午02:26:12 
 */
public class CommodityOrder_resultBean {
	/**
	 * 
	 */
	private String com_id;			//商品订单id
	private String nickname;		//用户昵称
	private String headimg;			//头像
	private int order_state;		//审核状态 0待审核1未通过2已通过
	private String create_time;		//创建时间、时间戳格式
	private String brand;			//品牌
	private double deposit;			//预订金
	private double total_price;		//价格
	private String c_name;			//商品名称
	private String cover_picture;	//商品封面图
	public String getCom_id() {
		return com_id;
	}
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getCover_picture() {
		return cover_picture;
	}
	public void setCover_picture(String cover_picture) {
		this.cover_picture = cover_picture;
	}

	
	
}

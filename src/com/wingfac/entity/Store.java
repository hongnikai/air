package com.wingfac.entity;

public class Store {

	private int s_id;			//店铺id
	private String au_id;		//用户id
	private String s_name;		//店铺名称
	private String s_type;		//店铺类型
	private String turnover; 	//交易额
	private String detail;		//店铺详情
	private int create_time;	//创建时间
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getAu_id() {
		return au_id;
	}
	public void setAu_id(String au_id) {
		this.au_id = au_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_type() {
		return s_type;
	}
	public void setS_type(String s_type) {
		this.s_type = s_type;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getCreate_time() {
		return create_time;
	}
	public void setCreate_time(int create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Store [s_id=" + s_id + ", au_id=" + au_id + ", s_name="
				+ s_name + ", s_type=" + s_type + ", turnover=" + turnover
				+ ", detail=" + detail + ", create_time=" + create_time + "]";
	}
	
	
	
}

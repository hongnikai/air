package com.wingfac.entity;
/**
 *  @描述:评价详情
 ** @author lc 
 *  创建时间：2018-2-28 下午02:26:12 
 */
public class CommodityEvaluate {
	/**
	 * 
	 */	
	private String eva_id;   //商品评价id商品评价id
	private String c_id;	 //商品id
	private String au_id;	 //创建者id
	private String com_id;	 //订单id
	private String nickname; //用户昵称
	private String head_img; //用户头像
	private String eva_time; //评价时间
	private String content;	 //评价内容
	private String picture;  //评价图片
	private String reply;	 //客服回复
	private int type;		 //状态(0-未回复/1-已回复)
	private int commodity_score;		 //商品评分
	private int sales_man_score;		 //销售员评分
	private int Installer_score;		 //安装工评价
	/**
	 * 
	 */
	public String getEva_id() {
		return eva_id;
	}
	public void setEva_id(String eva_id) {
		this.eva_id = eva_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getAu_id() {
		return au_id;
	}
	public void setAu_id(String au_id) {
		this.au_id = au_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHead_img() {
		return head_img;
	}
	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}
	public String getEva_time() {
		return eva_time;
	}
	public void setEva_time(String eva_time) {
		this.eva_time = eva_time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getCommodity_score() {
		return commodity_score;
	}
	public void setCommodity_score(int commodity_score) {
		this.commodity_score = commodity_score;
	}
	public int getSales_man_score() {
		return sales_man_score;
	}
	public void setSales_man_score(int sales_man_score) {
		this.sales_man_score = sales_man_score;
	}
	public int getInstaller_score() {
		return Installer_score;
	}
	public void setInstaller_score(int installer_score) {
		Installer_score = installer_score;
	}
	public String getCom_id() {
		return com_id;
	}
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	
	
}

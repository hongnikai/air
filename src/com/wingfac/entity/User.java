package com.wingfac.entity;
/**
 * user
 * @author LC
 *
 */
public class User {

	private String au_id;  			//用户id
	private String mobile;			//手机号/登录账号
	private String password;		//密码
	private String nickname;		//用户昵称
	private String headimg;			//头像
	private String create_time;		//创建时间
	private int type;				//身份（0-普通用户/1-销售/2-技术/3-管理/4-总管理员）
	private String score;			//评分
	private int sex;				//性别 0男1女
	private String address;			//默认地址
	private String collection;		//我的收藏
	private String other;			//其他
	private String pay_password;	//支付密码
	private int del_flag;			//删除标识 0-正常  1-禁止用户使用该帐号
	private String open_id;			//openid
	private int orderstate;			//删除标识 0-正常  1-禁止用户使用该帐号
	
	
	
	public String getAu_id() {
		return au_id;
	}
	public void setAu_id(String au_id) {
		this.au_id = au_id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getPay_password() {
		return pay_password;
	}
	public void setPay_password(String pay_password) {
		this.pay_password = pay_password;
	}
	public int getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;
	}
	public String getOpen_id() {
		return open_id;
	}
	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}
	public int getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}
	@Override
	public String toString() {
		return "User [au_id=" + au_id + ", mobile=" + mobile + ", password="
				+ password + ", nickname=" + nickname + ", headimg=" + headimg
				+ ", create_time=" + create_time + ", type=" + type
				+ ", score=" + score + ", sex=" + sex + ", address=" + address
				+ ", collection=" + collection + ", other=" + other
				+ ", pay_password=" + pay_password + ", del_flag=" + del_flag
				+ ", open_id=" + open_id + ", orderstate=" + orderstate + "]";
	}
	
	
	
	
}
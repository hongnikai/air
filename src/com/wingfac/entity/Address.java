package com.wingfac.entity;
/**
 *  @描述:地址表实体类
 ** @author lc 
 *  创建时间：2018-3-6 下午02:26:12 
 */
public class Address {
	/**
	 * 
	 */
	private String a_id;
	private String au_id;
	private String name;
	private String mobile;
	private String province;
	private String detail;
	private String create_time;
	/**
	 * 
	 */
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getAu_id() {
		return au_id;
	}
	public void setAu_id(String au_id) {
		this.au_id = au_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}	
	
}

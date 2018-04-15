package com.wingfac.entity;
/**
 *  @描述:保养订单
 ** @author lc 
 *  创建时间：2018-2-28 上午10:23:12 
 */
public class Maintain {
	/**
	* 
	* */
	private String maintain_id;			//保养id
	private String brand;				//空调品牌
	private String purpose;				//空调用途 0家用分体式1家用中央空调2商用中央空调
	private String type;				//空调类型 0挂机1柜机2天井机
	private String level;				//匹数
	/**
	* 
	* */
	public String getMaintain_id() {
		return maintain_id;
	}
	public void setMaintain_id(String maintain_id) {
		this.maintain_id = maintain_id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	
}

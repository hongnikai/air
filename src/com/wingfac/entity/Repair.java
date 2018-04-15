package com.wingfac.entity;
/**
 *  @描述:维修订单
 ** @author lc 
 *  创建时间：2018-2-28 上午 10:50:12 
 */
public class Repair {
 /**
  * 
  */	
	private String repair_id;		//维修id
	private String brand;			//空调品牌
	private String type;			//空调类型 0挂机1柜机2天井机
	private String purpose;			//空调用途
	private String level;			//匹数
	private String explains;			//问题故障说明
	 /**
	  * 
	  */
	public String getRepair_id() {
		return repair_id;
	}
	public void setRepair_id(String repair_id) {
		this.repair_id = repair_id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getExplains() {
		return explains;
	}
	public void setExplains(String explains) {
		this.explains = explains;
	}
	
	
}

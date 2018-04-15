package com.wingfac.entity;
/**
 *  @描述:安装实体类
 ** @author lc 
 *  创建时间：2018-2-26 下午02:26:12 
 */
public class Install {
  /**
	* 
	* */
	private String install_id;		//安装详情id
	private String brand;			//空调品牌
	private int purpose;			//空调用途 0家用分体式1家用中央空调2商用中央空调
	private int type;				//空调类型
	private String level;			//匹数
	/**
	 * 
	 **/
	public String getInstall_id() {
		return install_id;
	}
	public void setInstall_id(String install_id) {
		this.install_id = install_id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPurpose() {
		return purpose;
	}
	public void setPurpose(int purpose) {
		this.purpose = purpose;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	

	
	
}

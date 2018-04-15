package com.wingfac.entity;
/**
 *  @描述:问大家提问
 ** @author lc 
 *  创建时间：2018-3-1 上午10:56:12 
 */
public class CommodityAsk {
	/**
	 * 
	 */
	private String ask_id;				//问大家id
	private String c_id;				//商品id
	private String au_id;				//提问/回答者id
	private String ask_content;			//提问内容
	private String create_time;			//创建时间
	private String other;				//其他内容
	/**
	 * 
	 */
	public String getAsk_id() {
		return ask_id;
	}
	public void setAsk_id(String ask_id) {
		this.ask_id = ask_id;
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
	public String getAsk_content() {
		return ask_content;
	}
	public void setAsk_content(String ask_content) {
		this.ask_content = ask_content;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	
}

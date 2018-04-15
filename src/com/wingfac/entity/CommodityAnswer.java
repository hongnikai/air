package com.wingfac.entity;
/**
 *  @描述:问大家回答
 ** @author lc 
 *  创建时间：2018-3-1 上午 11:00:12 
 */
public class CommodityAnswer {
	/**
	 * 
	 */
	private String answer_id;				//问大家回答id
	private String ask_id;					//问题id
	private String au_id;					//回答者id
	private String answer_content;			//回答内容
	private String create_time;				//回答时间
	private Integer useful;					//点赞,有用 
	/**
	 * 
	 */
	public String getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(String answer_id) {
		this.answer_id = answer_id;
	}
	public String getAsk_id() {
		return ask_id;
	}
	public void setAsk_id(String ask_id) {
		this.ask_id = ask_id;
	}
	public String getAu_id() {
		return au_id;
	}
	public void setAu_id(String au_id) {
		this.au_id = au_id;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public Integer getUseful() {
		return useful;
	}
	public void setUseful(Integer useful) {
		this.useful = useful;
	}
	
	
}

package com.wingfac.entity;
/**
 *  @描述:保养订单实体类
 ** @author lc 
 *  创建时间：2018-3-2 上午10:23:12 
 */
public class MaintainOrder {
	/**
	* 
	* */
	private String maintain_order_id;				//保养订单id
	private String maintain_id;						//保养id
	private String au_id;							//创建者id	
	private String time;							//预约上门时间
	private String person;							//联系人
	private String tellphone;						//联系电话
	private String address;							//收货地址
	private double total_price;						//总价格
	private double deposit;							//预定金
	private double retainage;						//尾款
	private int time_stage;							//安装时间段 0全天1上午2下午
	private String create_time;						//订单创建时间
	private int order_state;						//订单状态 0未支付1已支付,2待收货3已收货4安装中5保养中6维修中7已评价
	private String maintain_man_id;					//保养人id
	private String go_indoor_picture;				//上门保养图片
	private String yali_dianliu_weixiu;				//压力电流维修检测图片
	private String clean_before;					//清洗前照片
	private String clean_ing;						//清洗中
	private String clean_after;						//清洗后图片
	private String complet_opinion;					//维修完工建议
	/**
	* 
	* */
	public String getMaintain_order_id() {
		return maintain_order_id;
	}
	public void setMaintain_order_id(String maintain_order_id) {
		this.maintain_order_id = maintain_order_id;
	}
	public String getMaintain_id() {
		return maintain_id;
	}
	public void setMaintain_id(String maintain_id) {
		this.maintain_id = maintain_id;
	}
	public String getAu_id() {
		return au_id;
	}
	public void setAu_id(String au_id) {
		this.au_id = au_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getTellphone() {
		return tellphone;
	}
	public void setTellphone(String tellphone) {
		this.tellphone = tellphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getRetainage() {
		return retainage;
	}
	public void setRetainage(double retainage) {
		this.retainage = retainage;
	}
	public int getTime_stage() {
		return time_stage;
	}
	public void setTime_stage(int time_stage) {
		this.time_stage = time_stage;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public String getMaintain_man_id() {
		return maintain_man_id;
	}
	public void setMaintain_man_id(String maintain_man_id) {
		this.maintain_man_id = maintain_man_id;
	}
	public String getGo_indoor_picture() {
		return go_indoor_picture;
	}
	public void setGo_indoor_picture(String go_indoor_picture) {
		this.go_indoor_picture = go_indoor_picture;
	}
	public String getYali_dianliu_weixiu() {
		return yali_dianliu_weixiu;
	}
	public void setYali_dianliu_weixiu(String yali_dianliu_weixiu) {
		this.yali_dianliu_weixiu = yali_dianliu_weixiu;
	}
	public String getClean_before() {
		return clean_before;
	}
	public void setClean_before(String clean_before) {
		this.clean_before = clean_before;
	}
	public String getClean_ing() {
		return clean_ing;
	}
	public void setClean_ing(String clean_ing) {
		this.clean_ing = clean_ing;
	}
	public String getClean_after() {
		return clean_after;
	}
	public void setClean_after(String clean_after) {
		this.clean_after = clean_after;
	}
	public String getComplet_opinion() {
		return complet_opinion;
	}
	public void setComplet_opinion(String complet_opinion) {
		this.complet_opinion = complet_opinion;
	}
	
	
}

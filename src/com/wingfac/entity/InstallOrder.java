package com.wingfac.entity;
/**
 *  @描述:安装订单
 ** @author lc 
 *  创建时间：2018-2-26 下午02:26:12 
 */
public class InstallOrder {
/**
 * 
 **/
	private String install_order_id;    //安装订单id
	private String install_id;			//安装id
	private String au_id;				//创建者id
	private String time;				//预约上门时间
	private String person;				//联系人
	private String tellphone;			//联系电话
	private String address;				//收货地址
	private double total_price;			//总价格
	private double deposit;				//预定金
	private double retainage;			//尾款
	private int time_stage;				//安装时间段 0全天1上午2下午
	private String create_time;			//订单创建时间
	private int order_state;			//订单状态 0未支付1已支付,2待收货3已收货4安装中5保养中6维修中7已评价
	private String install_man_id;      //安装人id
	private String go_indoor_picture;	//上门安装图片
	private String area_pictrue;		//安装位置图片
	private String make_sure_picture;	//安装确认图片
	
	
/**
 * 
 **/
	public String getInstall_order_id() {
		return install_order_id;
	}
	public void setInstall_order_id(String install_order_id) {
		this.install_order_id = install_order_id;
	}
	public String getInstall_id() {
		return install_id;
	}
	public void setInstall_id(String install_id) {
		this.install_id = install_id;
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
	public String getInstall_man_id() {
		return install_man_id;
	}
	public void setInstall_man_id(String install_man_id) {
		this.install_man_id = install_man_id;
	}
	public String getGo_indoor_picture() {
		return go_indoor_picture;
	}
	public void setGo_indoor_picture(String go_indoor_picture) {
		this.go_indoor_picture = go_indoor_picture;
	}
	public String getArea_pictrue() {
		return area_pictrue;
	}
	public void setArea_pictrue(String area_pictrue) {
		this.area_pictrue = area_pictrue;
	}
	public String getMake_sure_picture() {
		return make_sure_picture;
	}
	public void setMake_sure_picture(String make_sure_picture) {
		this.make_sure_picture = make_sure_picture;
	}	
	
	
	
}

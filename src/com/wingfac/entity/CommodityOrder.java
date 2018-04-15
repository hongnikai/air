package com.wingfac.entity;
/**
 *  @描述:订单
 ** @author lc   
 *  创建时间：2018-2-8 下午15:39
 */
public class CommodityOrder {
	/**
	 * 
	 */
	private String com_id;			//商品订单id
	private String au_id;			//创建者id(买家id)
	private String c_id;			//商品id
	private int order_state;		//订单状态 0未支付1已支付,2待收货3已收货4安装中5保养中6维修中7已评价
	private double total_price;		//价格
	private String pay_time;		//支付时间
	private String pay_id;			//支付id
	private String create_time;		//创建时间
	private String leave_message;   //买家留言
	private String a_id;			//地址id
	private int slice_flag;			//分期标识 0不分期 1分期
	private double deposit;			//预订金
	private double retainage;		//尾款
	private String saleman_id;		//销售接单人的id
	
	
	public String getCom_id() {
		return com_id;
	}
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	public String getAu_id() {
		return au_id;
	}
	public void setAu_id(String au_id) {
		this.au_id = au_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public String getPay_time() {
		return pay_time;
	}
	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getLeave_message() {
		return leave_message;
	}
	public void setLeave_message(String leave_message) {
		this.leave_message = leave_message;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public int getSlice_flag() {
		return slice_flag;
	}
	public void setSlice_flag(int slice_flag) {
		this.slice_flag = slice_flag;
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
	
	public String getSaleman_id() {
		return saleman_id;
	}
	public void setSaleman_id(String saleman_id) {
		this.saleman_id = saleman_id;
	}
	@Override
	public String toString() {
		return "CommodityOrder [com_id=" + com_id + ", au_id=" + au_id
				+ ", c_id=" + c_id + ", order_state=" + order_state
				+ ", total_price=" + total_price + ", pay_time=" + pay_time
				+ ", pay_id=" + pay_id + ", create_time=" + create_time
				+ ", leave_message=" + leave_message + ", a_id=" + a_id
				+ ", slice_flag=" + slice_flag + ", deposit=" + deposit
				+ ", retainage=" + retainage + "]";
	}
	
	
}

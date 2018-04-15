package com.wingfac.entity;
/**
 *  @描述:维修订单实体类
 ** @author lc 
 *  创建时间：2018-3-3 上午10:23:12 
 */
public class RepairOrder {
	/**
	* 
	* */
		private String repair_order_id;
		private String repair_id;
		private String au_id;
		private String time;
		private String person;
		private String tellphone;
		private String address;
		private double total_price;
		private double deposit;
		private double retainage;
		private int time_stage;
		private String create_time;
		private int order_state;			//订单状态 0未支付1已支付,2待收货3已收货4安装中5保养中6维修中7已评价
		private String repair_man_id;		//维修员工id	
		private String go_indoor_picture;	//上门维修照片
		private String jiqi_jiance_picture;	//机器检测照片
		private String change_part_picture;	//维修更换部件照片
		private String repair_detail;		//维修详情
		private double repair_price;		//维修报价
		private String complet_opinion;		//维修完工建议
		
		
		
/**
 * 
 **/
		public String getRepair_order_id() {
			return repair_order_id;
		}
		public void setRepair_order_id(String repair_order_id) {
			this.repair_order_id = repair_order_id;
		}
		public String getRepair_id() {
			return repair_id;
		}
		public void setRepair_id(String repair_id) {
			this.repair_id = repair_id;
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
		
		
		
}

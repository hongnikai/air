package com.wingfac.entity;
/**
 *  @描述:商品
 ** @author lc 
 *  创建时间：2018-2-12 下午02:26:12 
 */
public class Commodity {
	/**
	 * 
	 */
	private String c_id;			//产品id
	private int s_id;				//店铺id
	private String com_id;			//订单id
	private String c_name;			//商品名称
	private double price;			//商品单价(默认价格为0)
	private int buy_num;			//购买数量
	private String cover_picture;	//首页图片
	private String detaile_picture; //详情图片
	private int delete_flag;		//删除标识
	private String brand;			//品牌
	private int use_type;			//用途分类 0家用分体式1家用中央空调2商用中央空调
	private int type;				//分类 0挂机1柜机2天井机
	private int frequency;			//频率 0定频1变频
	private String level;			//匹数
	private String create_time;		//上市时间
	private String repair_time;		//保修日期
	private String insert_pack_size;//内机包装尺寸
	private String insert_plies_max; //内机堆码层数极限
	private String insert_weight;	//内机毛重
	private String insert_size;		//内机尺寸
	private String cold_power;		//制冷功率
	private String cold_amount;		//制冷量
	private String hot_power;		//制热功率
	private String hot_amount;		//制热量
	private String out_pack_size;	//外机包装尺寸
	private String out_plies_max;	//外机堆码层数极限
	private String out_size;		//外机尺寸
	private String out_weight;		//外机毛重
	private String indoor_noise;	//室内机噪音
	private String outdoor_noise;	//室外机噪音
	private String smart_type;		//智能类型
	private String heating_power;	//电辅加热功率
	private String air_board_color; //空调面板颜色
	private String efficiency_number;//能效备案号
	private String air_type;		//空调类型
	private String temperature_type;//冷暖类型
	private String air_power;		//空调功率
	private String suit_area;		//适用面积
	private String customer_service;//售后服务
	private String work_method;		//工作方式
	private String power_level;		//能效等级
	private String wind_refresh_yes_or_not;//是否循环风量
	private String out_net_weight;  //室外净机重量
	private String insert_net_weight;//室内净机重量
	private String commodity_details;//商品详情(文字内容)
	private int commodity_mark;     //商品标记 0普通商品1折扣专区2热销商品
	/**
	 * 
	 */
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getCom_id() {
		return com_id;
	}
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}
	public String getCover_picture() {
		return cover_picture;
	}
	public void setCover_picture(String cover_picture) {
		this.cover_picture = cover_picture;
	}
	public String getDetaile_picture() {
		return detaile_picture;
	}
	public void setDetaile_picture(String detaile_picture) {
		this.detaile_picture = detaile_picture;
	}
	public int getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getUse_type() {
		return use_type;
	}
	public void setUse_type(int use_type) {
		this.use_type = use_type;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getRepair_time() {
		return repair_time;
	}
	public void setRepair_time(String repair_time) {
		this.repair_time = repair_time;
	}
	public String getInsert_pack_size() {
		return insert_pack_size;
	}
	public void setInsert_pack_size(String insert_pack_size) {
		this.insert_pack_size = insert_pack_size;
	}
	public String getInsert_plies_max() {
		return insert_plies_max;
	}
	public void setInsert_plies_max(String insert_plies_max) {
		this.insert_plies_max = insert_plies_max;
	}
	public String getInsert_weight() {
		return insert_weight;
	}
	public void setInsert_weight(String insert_weight) {
		this.insert_weight = insert_weight;
	}
	public String getInsert_size() {
		return insert_size;
	}
	public void setInsert_size(String insert_size) {
		this.insert_size = insert_size;
	}
	public String getCold_power() {
		return cold_power;
	}
	public void setCold_power(String cold_power) {
		this.cold_power = cold_power;
	}
	public String getCold_amount() {
		return cold_amount;
	}
	public void setCold_amount(String cold_amount) {
		this.cold_amount = cold_amount;
	}
	public String getOut_pack_size() {
		return out_pack_size;
	}
	public void setOut_pack_size(String out_pack_size) {
		this.out_pack_size = out_pack_size;
	}
	public String getOut_plies_max() {
		return out_plies_max;
	}
	public void setOut_plies_max(String out_plies_max) {
		this.out_plies_max = out_plies_max;
	}
	public String getOut_size() {
		return out_size;
	}
	public void setOut_size(String out_size) {
		this.out_size = out_size;
	}
	public String getOut_weight() {
		return out_weight;
	}
	public void setOut_weight(String out_weight) {
		this.out_weight = out_weight;
	}
	public String getIndoor_noise() {
		return indoor_noise;
	}
	public void setIndoor_noise(String indoor_noise) {
		this.indoor_noise = indoor_noise;
	}
	public String getOutdoor_noise() {
		return outdoor_noise;
	}
	public void setOutdoor_noise(String outdoor_noise) {
		this.outdoor_noise = outdoor_noise;
	}
	public String getSmart_type() {
		return smart_type;
	}
	public void setSmart_type(String smart_type) {
		this.smart_type = smart_type;
	}
	public String getHeating_power() {
		return heating_power;
	}
	public void setHeating_power(String heating_power) {
		this.heating_power = heating_power;
	}
	public String getAir_board_color() {
		return air_board_color;
	}
	public void setAir_board_color(String air_board_color) {
		this.air_board_color = air_board_color;
	}
	public String getEfficiency_number() {
		return efficiency_number;
	}
	public void setEfficiency_number(String efficiency_number) {
		this.efficiency_number = efficiency_number;
	}
	public String getAir_type() {
		return air_type;
	}
	public void setAir_type(String air_type) {
		this.air_type = air_type;
	}
	public String getTemperature_type() {
		return temperature_type;
	}
	public void setTemperature_type(String temperature_type) {
		this.temperature_type = temperature_type;
	}
	public String getAir_power() {
		return air_power;
	}
	public void setAir_power(String air_power) {
		this.air_power = air_power;
	}
	public String getSuit_area() {
		return suit_area;
	}
	public void setSuit_area(String suit_area) {
		this.suit_area = suit_area;
	}
	public String getCustomer_service() {
		return customer_service;
	}
	public void setCustomer_service(String customer_service) {
		this.customer_service = customer_service;
	}
	public String getWork_method() {
		return work_method;
	}
	public void setWork_method(String work_method) {
		this.work_method = work_method;
	}
	public String getPower_level() {
		return power_level;
	}
	public void setPower_level(String power_level) {
		this.power_level = power_level;
	}
	public String getWind_refresh_yes_or_not() {
		return wind_refresh_yes_or_not;
	}
	public void setWind_refresh_yes_or_not(String wind_refresh_yes_or_not) {
		this.wind_refresh_yes_or_not = wind_refresh_yes_or_not;
	}
	public String getOut_net_weight() {
		return out_net_weight;
	}
	public void setOut_net_weight(String out_net_weight) {
		this.out_net_weight = out_net_weight;
	}
	public String getInsert_net_weight() {
		return insert_net_weight;
	}
	public void setInsert_net_weight(String insert_net_weight) {
		this.insert_net_weight = insert_net_weight;
	}
	public String getCommodity_details() {
		return commodity_details;
	}
	public void setCommodity_details(String commodity_details) {
		this.commodity_details = commodity_details;
	}
	public int getCommodity_mark() {
		return commodity_mark;
	}
	public void setCommodity_mark(int commodity_mark) {
		this.commodity_mark = commodity_mark;
	}
	
	public String getHot_power() {
		return hot_power;
	}
	public void setHot_power(String hot_power) {
		this.hot_power = hot_power;
	}
	public String getHot_amount() {
		return hot_amount;
	}
	public void setHot_amount(String hot_amount) {
		this.hot_amount = hot_amount;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Commodity [c_id=" + c_id + ", s_id=" + s_id + ", com_id="
				+ com_id + ", c_name=" + c_name + ", price=" + price
				+ ", buy_num=" + buy_num + ", cover_picture=" + cover_picture
				+ ", detaile_picture=" + detaile_picture + ", delete_flag="
				+ delete_flag + ", brand=" + brand + ", use_type=" + use_type
				+ ", type=" + type + ", frequency=" + frequency + ", level="
				+ level + ", create_time=" + create_time + ", repair_time="
				+ repair_time + ", insert_pack_size=" + insert_pack_size
				+ ", insert_plies_max=" + insert_plies_max + ", insert_weight="
				+ insert_weight + ", insert_size=" + insert_size
				+ ", cold_power=" + cold_power + ", cold_amount=" + cold_amount
				+ ", hot_power=" + hot_power + ", hot_amount=" + hot_amount
				+ ", out_pack_size=" + out_pack_size + ", out_plies_max="
				+ out_plies_max + ", out_size=" + out_size + ", out_weight="
				+ out_weight + ", indoor_noise=" + indoor_noise
				+ ", outdoor_noise=" + outdoor_noise + ", smart_type="
				+ smart_type + ", heating_power=" + heating_power
				+ ", air_board_color=" + air_board_color
				+ ", efficiency_number=" + efficiency_number + ", air_type="
				+ air_type + ", temperature_type=" + temperature_type
				+ ", air_power=" + air_power + ", suit_area=" + suit_area
				+ ", customer_service=" + customer_service + ", work_method="
				+ work_method + ", power_level=" + power_level
				+ ", wind_refresh_yes_or_not=" + wind_refresh_yes_or_not
				+ ", out_net_weight=" + out_net_weight + ", insert_net_weight="
				+ insert_net_weight + ", commodity_details="
				+ commodity_details + ", commodity_mark=" + commodity_mark
				+ "]";
	}
	
	
	
	
	
}

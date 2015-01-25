package com.thoughtworks.homework.entity;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.homework.util.HRUtil;



/**

 * 

* @ClassName: Order 

* @Description: information about order 

* @author 6272188    

* @date 2015-1-12 下午05:26:00 

*

 */

public class Order{

	private String orderId;

	private List<String> daysList;

	private int totalCharge;

	//此处为了方便用customerName作为两个实体之间的联系，当采用数据库时可以用customerId作为外键关联

	private String customerName;

	private String hotelName;

	

	public Order(){

		

	}

	

	public Order(String cfgFileName){

		Map<String, String> orderInfoMap = new HashMap<String, String>();

		orderInfoMap = HRUtil.readOrderInfo(cfgFileName);

		

		this.customerName = orderInfoMap.get("customerName");

		this.daysList = HRUtil.stringToList(orderInfoMap.get("daysList"), ",");

	}

	

	public Order(String orderId, String customerName, List<String> daysList){

		this.orderId = orderId;

		this.customerName = customerName;

		this.daysList = daysList;

	}

	

	public int getTotalCharge() {

		return totalCharge;

	}



	public void setTotalCharge(int totalCharge) {

		this.totalCharge = totalCharge;

	}



	public String getOrderId() {

		return orderId;

	}

	public void setOrderId(String orderId) {

		this.orderId = orderId;

	}

	

	public List<String> getDaysList() {

		return daysList;

	}



	public void setDaysList(List<String> daysList) {

		this.daysList = daysList;

	}



	public String getCustomerName() {

		return customerName;

	}

	public void setCustomerName(String customerName) {

		this.customerName = customerName;

	}



	public String getHotelName() {

		return hotelName;

	}



	public void setHotelName(String hotelName) {

		this.hotelName = hotelName;

	}

}
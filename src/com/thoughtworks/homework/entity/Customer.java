package com.thoughtworks.homework.entity;



import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.homework.util.HRUtil;



/**

 * 

* @ClassName: Customer 

* @Description:describe customer information like customer type and name 

* @author 6272188    

* @date 2015-1-15 ÏÂÎç03:27:04 

*

 */

public class Customer {

	private String customerName;

	private String customerType;

	private String customerId;

	private int customerSex;

	private int customerAge;

	

	public Customer(){

		

	}

	

	public Customer(String cfgFileName){

		Map<String, String> orderInfoMap = new HashMap<String, String>();

		orderInfoMap = HRUtil.readOrderInfo(cfgFileName);

		

		this.customerName = orderInfoMap.get("customerName");

		this.customerType = orderInfoMap.get("customerType");

	}

	

	public String getCustomerName() {

		return customerName;

	}

	public void setCustomerName(String customerName) {

		this.customerName = customerName;

	}



	public String getCustomerType() {

		return customerType;

	}

	public void setCustomerType(String customerType) {

		this.customerType = customerType;

	}

	public String getCustomerId() {

		return customerId;

	}

	public void setCustomerId(String customerId) {

		this.customerId = customerId;

	}

	public int getCustomerSex() {

		return customerSex;

	}

	public void setCustomerSex(int customerSex) {

		this.customerSex = customerSex;

	}

	public int getCustomerAge() {

		return customerAge;

	}

	public void setCustomerAge(int customerAge) {

		this.customerAge = customerAge;

	}

}
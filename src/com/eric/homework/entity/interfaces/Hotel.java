package com.eric.homework.entity.interfaces;





import java.util.Date;
import java.util.Map;

import com.eric.homework.entity.Customer;
import com.eric.homework.entity.Order;





/**

 * 

* @ClassName: HotelInterface 

* @Description: Interface of hotel to define basic method of all hotel 

* @author 6272188    

* @date 2015-1-12 ÏÂÎç02:56:36 

*

 */

public interface Hotel {

	//calculate the final charge customer should pay for their order

	public Order caculateTotalPrice(Order order, float discount) throws Exception;

	

	//is user vip or regular p

	public boolean isVIP(Customer customer) throws Exception;

	

	//read hotel's price information from configure files 

	public Map<String, Integer> definePrice() throws Exception;

	

	//define discount based on customer's information

	public float defineDiscount(Customer customer) throws Exception;

	

	//calculate everyday charge based on customer information and date

	public int calculateDayCharge(Customer customer, Date date) throws Exception;

	

	//calculate total charge based on customer information and order information

	public Order calculateTotalCharge(Customer customer, Order order) throws Exception;

}


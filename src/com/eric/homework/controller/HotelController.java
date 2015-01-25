package com.eric.homework.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.eric.homework.entity.Customer;
import com.eric.homework.entity.Order;
import com.eric.homework.service.HotelManager;
import com.eric.homework.util.HRUtil;



/**

 * 

* @ClassName: BookHotelController 

* @Description: 

* @author 6272188    

* @date 2015-1-13 ÏÂÎç03:04:14 

*

 */

public class HotelController {

	public static ArrayList<String> hotelNames = new ArrayList<String>();
	public HotelManager hotelManager = new HotelManager();

	

	public HotelController(){

		//initialize hotel names 
		Map<String, Map<String, Integer>> hotelNamsMap = new HashMap<String, Map<String,Integer>>();

		hotelNamsMap = HRUtil.readHotelPrice("hotelCfg.xml");

		Iterator<String> iterator = hotelNamsMap.keySet().iterator();

		while(iterator.hasNext()){

			String temStr = iterator.next();

			hotelNames.add(temStr);

		}

	}


	public void findHotel(){
		//create customer
		Customer customer = new Customer("input.xml");

		//create order
		Order order = new Order("input.xml");

		hotelManager.getChepestHotel(hotelNames,customer,order);
	}

}







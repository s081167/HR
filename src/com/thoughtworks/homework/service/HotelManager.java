package com.thoughtworks.homework.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.thoughtworks.homework.entity.BaseHotel;
import com.thoughtworks.homework.entity.Customer;
import com.thoughtworks.homework.entity.Order;
import com.thoughtworks.homework.entity.interfaces.Hotel;

/**
 * 
 * @author Administrator
 *
 */
public class HotelManager {
	/**

	 * 

	* @Title: getHotel 

	* @Description:create hotel object based on its name  

	* @param @param hotelName

	* @param @return

	* @return Hotel

	* @throws

	 */

	public Hotel getHotel(String hotelName){

		Hotel hotel = null;

		if("BW".equals(hotelName)){

			//hotel = new BWHotel();
			hotel = new BaseHotel("BW");

		}else if ("LW".equals(hotelName)) {

			//hotel = new LWHotel();
			hotel = new BaseHotel("LW");

		}else if("RW".equals(hotelName)){

			//hotel = new RWHotel();
			hotel = new BaseHotel("RW");

		}		

		return hotel;

	}
	
	/**

	 * 

	* @Title: getChepestHotel 

	* @Description:  get cheapest hotel

	* @param @param order

	* @return void

	* @throws

	 */

	public void getChepestHotel(ArrayList<String> hotels, Customer customer,Order order){

		Map<String, Order> subHotelCharge = calculaeAllHotelCharge(hotels,customer,order);

		Collection<String> hotelName = subHotelCharge.keySet();

		Iterator<String> iterator = hotelName.iterator();


		String cheapHotelName = iterator.next();

		Integer cheapCharge = subHotelCharge.get(cheapHotelName).getTotalCharge();
		//System.out.println(cheapHotelName+": "+cheapCharge);

		

		while(iterator.hasNext()){

			//有两家旅馆价格一样怎么办？如果价格相同则比较星级，取星级高的返回

			String temName = iterator.next();
			
			/*System.out.print(temName);
			System.out.println(": "+subHotelCharge.get(temName).getTotalCharge());*/
			

			if(cheapCharge>=subHotelCharge.get(temName).getTotalCharge()){

				cheapHotelName = temName;

				cheapCharge = subHotelCharge.get(temName).getTotalCharge();

			}

		}

		System.out.println("Cheapest Hotel Name:"+cheapHotelName);
		System.out.println("Its Charge is:"+cheapCharge);
	}

	

	/**

	 * 

	* @Title: calculaeAllHotelCharge 

	* @Description:calculate every hotel's charge  

	* @param @param order

	* @param @return

	* @return Map<String,Integer>

	* @throws

	 */

	public Map<String, Order> calculaeAllHotelCharge(ArrayList<String> hotels, Customer customer, Order order){

		Map<String, Order> subHotelPriceMap = new HashMap<String, Order>();

		try {

			//calculate total charge of order

			for (int i = 0; i < hotels.size(); i++) {

				Hotel hotel = new BaseHotel();

				Order resultOrder = new Order();

				 

				hotel = getHotel(hotels.get(i)); 

				

				//calculate discount and everyday charge

				hotel.defineDiscount(customer);

				

				//calculate current hotel's daily charge and put it in map

				Order tempOrder = hotel.calculateTotalCharge(customer, order);

				resultOrder.setTotalCharge(tempOrder.getTotalCharge());

				resultOrder.setCustomerName(tempOrder.getCustomerName());

				resultOrder.setDaysList(tempOrder.getDaysList());

				resultOrder.setOrderId(tempOrder.getOrderId());

				

				subHotelPriceMap.put(hotels.get(i), resultOrder);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}



		//return total charge

		return subHotelPriceMap;

	}
}

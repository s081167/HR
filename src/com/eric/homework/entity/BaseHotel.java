package com.eric.homework.entity;





import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.eric.homework.entity.interfaces.Hotel;
import com.eric.homework.util.HRUtil;



/**

 * 

* @ClassName: BaseHotel 

* @Description: base hotel to define the character of all class

* @author 6272188    

* @date 2015-1-12 ÏÂÎç02:59:32 

*

 */

public class BaseHotel implements Hotel{

	protected final String CONFIG_FILE_NAME = "hotelCfg.xml";

	protected final Map<String, Map<String, Integer>> HOTEL_INFO_MAP = HRUtil.readHotelPrice(CONFIG_FILE_NAME);

	protected String hotelName;
	

	protected int starLevel;

	protected Map<String, Integer> priceMap = new HashMap<String, Integer>();

	
	public BaseHotel(){
		
	}

	public BaseHotel(String hotelName){
		this.hotelName = hotelName;

		this.starLevel =  this.HOTEL_INFO_MAP.get(hotelName).get("starLevel");
		this.priceMap =this.HOTEL_INFO_MAP.get(hotelName);
	}

	

	@Override

	public int calculateDayCharge(Customer customer, Date date)

			throws Exception {

		int dayCharge = 0;

		if(HRUtil.isWeekend(date)){

			if(isVIP(customer)){

				dayCharge = dayCharge + definePrice().get("weekendPriceVip"); 

			}else{

				dayCharge = dayCharge + definePrice().get("weekendPriceP");

			}			

		}else{

			if(isVIP(customer)){

				dayCharge = dayCharge + definePrice().get("weekdayPriceVip");

			}else{

				dayCharge = dayCharge + definePrice().get("weekdayPriceP");

			}

		}

		

		//return

		return dayCharge;

	}



	@Override

	public Order calculateTotalCharge(Customer customer, Order order)

			throws Exception {

		int totalCharge = 0;

		Order resultOrder = order;

		

		if(order.getDaysList().size()>0){

			//calculate total charge based on date and everyday charge

			for (int i = 0; i < order.getDaysList().size(); i++) {

				//change date

				Date date = HRUtil.stringToDate(order.getDaysList().get(i), "yyyy-MM-dd");

				totalCharge = totalCharge + calculateDayCharge(customer,date);

			}

		}

		

		//set final charge to order

		resultOrder.setTotalCharge(totalCharge);

		//return

		return resultOrder;

	}



	@Override

	public boolean isVIP(Customer customer) throws Exception {

		boolean isVip = false;

		//check from database, you can overwrite this method as you want

		if("VIP".equals(customer.getCustomerType())){

			isVip = true;

		}

		

		return isVip;

	}



	@Override

	public float defineDiscount(Customer customer) throws Exception {

		float discount = 1;

		//pacific hotel can define how to calculate discount as their rules

		if("VIP".equals(customer.getCustomerType())){

			discount = 0.8f;

		}

		return discount;

	}





	@Override

	public Order caculateTotalPrice(Order order, float discount) throws Exception  {

		// Auto-generated method stub

		return null;

	}



	@Override

	public Map<String, Integer> definePrice() throws Exception  {

		return getPriceMap();

	}



	public Map<String, Integer> getPriceMap() {

		return priceMap;

	}



	public void setPriceMap(Map<String, Integer> priceMap) {

		this.priceMap = priceMap;

	}

}
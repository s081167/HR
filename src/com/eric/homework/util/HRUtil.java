package com.eric.homework.util;



import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



/**

 * 

* @ClassName: HRUtil 

* @Description:define some public method as tool 

* @author 6272188    

* @date 2015-1-13 ÏÂÎç04:33:17 

*

 */

public class HRUtil {

	/**

	 * 

	* @Title: readHotelPrice 

	* @Description:read price from config file  

	* @param @param filaName

	* @param @return

	* @return Map<String,Map<String,Integer>>

	* @throws

	 */

	@SuppressWarnings("unchecked")

	public static Map<String, Map<String, Integer>> readHotelPrice(String fileName){

		Map<String, Map<String, Integer>> priceMap = new HashMap<String, Map<String,Integer>>();

		SAXReader saxReader = new SAXReader();

		try {

			Document document = saxReader.read(new File(System.getProperty("user.dir")+"\\bin\\com\\eric\\homework\\config\\"+fileName));

			Element root = document.getRootElement();

			List hotels = root.elements("hotel");

		    

			for (int i = 0; i < hotels.size(); i++) {

				Element hotel = (Element) hotels.get(i);				

				Map<String, Integer> temHotelPriceMap = new HashMap<String, Integer>();

 				String temHotelName = hotel.attributeValue("name");

				temHotelPriceMap.put("starLevel", Integer.parseInt(hotel.attributeValue("starLevel")));

				temHotelPriceMap.put("weekdayPriceP", Integer.parseInt(hotel.attributeValue("weekdayP")));

				temHotelPriceMap.put("weekdayPriceVip", Integer.parseInt(hotel.attributeValue("weekdayVip")));

				temHotelPriceMap.put("weekendPriceP", Integer.parseInt(hotel.attributeValue("weekendP")));

				temHotelPriceMap.put("weekendPriceVip", Integer.parseInt(hotel.attributeValue("weekendVip")));

				

				priceMap.put(temHotelName, temHotelPriceMap);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		

		return priceMap;

	}

	

	@SuppressWarnings("unchecked")

	public static Map<String, String> readOrderInfo(String fileName){

		Map<String, String> orderInfoMap = new HashMap<String,String>();

		SAXReader saxReader = new SAXReader();

		try {

			Document document = saxReader.read(new File(System.getProperty("user.dir")+"\\bin\\com\\eric\\homework\\config\\"+fileName));

			Element root = document.getRootElement();

			List customers = root.elements("customer");

		    

			for (int i = 0; i < customers.size(); i++) {

				Element customer = (Element) customers.get(i);	

				

				orderInfoMap.put("customerName", customer.attributeValue("name"));

				orderInfoMap.put("customerType", customer.attributeValue("type"));

				orderInfoMap.put("daysList", customer.attributeValue("days"));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		

		return orderInfoMap;

	}

	

	/**

	 * 

	* @Title: getAfterDate 

	* @Description: get next day  

	* @param @param d

	* @param @return

	* @return Date

	* @throws

	 */

	public static Date getAfterDate(Date d) {

		Date date = null;

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(d);

		calendar.add(Calendar.DAY_OF_MONTH, 1);

		date = calendar.getTime();

		return date;

	}

	

	/**

	 * 

	* @Title: stringToDate 

	* @Description:change string date to Date  

	* @param @param strDate

	* @param @param foramt

	* @param @return

	* @return Date

	* @throws

	 */

	public static Date stringToDate(String strDate,String foramt){

		Date date = null;

		try {

			DateFormat dateFormat = new SimpleDateFormat(foramt); 

			date = dateFormat.parse(strDate); 

		} catch (Exception e) {

			//

		}

		

		return date;

	}

	

	/**

	 * 

	* @Title: isWeekend 

	* @Description:  to check the date is weekend or weekday

	* @param @param strDate

	* @param @return

	* @return boolean

	* @throws

	 */

	public static boolean isWeekend(String strDate){

		boolean isWeekend = false;

		String[] dateStr = strDate.split("-");

		Calendar calendar = Calendar.getInstance(java.util.Locale.CHINA);

		

		//set year month and day

		calendar.set(Calendar.YEAR,Integer.parseInt(dateStr[0]));

		calendar.set(Calendar.MONTH,Integer.parseInt(dateStr[1])-1);

		calendar.set(Calendar.DATE,Integer.parseInt(dateStr[2]));

		

	    int weekday = calendar.get(Calendar.DAY_OF_WEEK);

	    

	    //check is it weekend

	    if(1==weekday || 7==weekday){

	    	isWeekend = true;

	    }

	    

	    //return result

	    return isWeekend;

	}

	

	/**

	 * 

	* @Title: isWeekend 

	* @Description: check is it weekend based on Date  

	* @param @param date

	* @param @return

	* @return boolean

	* @throws

	 */

	public static boolean isWeekend(Date date){

		boolean isWeekend = false;

		Calendar calendar = Calendar.getInstance(java.util.Locale.CHINA);

		

		//set year month and day

		calendar.setTime(date);

		

	    //check is it weekend

	    if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){

	    	isWeekend = true;

	    }

	    

	    //return result

	    return isWeekend;

	}

	

	/**

	 * 

	* @Title: stringToList 

	* @Description:convert days string to arrayList  

	* @param @param orinalStr

	* @param @param seperater

	* @param @return

	* @return List<String>

	* @throws

	 */

	public static List<String> stringToList(String orinalStr,String seperater){

		List<String> resultList = new ArrayList<String>();

		String[] stringArr = orinalStr.split(seperater);

		

		for(String str : stringArr){

			resultList.add(str);

		}

		

		return resultList;

	}

	

	public static void main(String[] args) {

		//HRUtil hrUtil = new HRUtil();

		//hrUtil.readHotelPrice("");

		System.out.println(isWeekend(stringToDate("2009-03-18","yyyy-MM-dd")));

		//System.out.println(getAfterDate(new Date()));

	}

}

package com.eric.homework;

import com.eric.homework.controller.HotelController;


public class Launcher {
	public static HotelController hotelController = new HotelController();
	
	/**
	 * 
	* @Title: main 
	* @Description: 
	* @param @param args    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void main(String[] args) {
		hotelController.findHotel();
	}
}

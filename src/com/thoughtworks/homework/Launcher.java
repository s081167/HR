package com.thoughtworks.homework;

import com.thoughtworks.homework.controller.HotelController;


public class Launcher {
	public static HotelController hotelController = new HotelController();
	
	/**
	 * 
	* @Title: main 
	* @Description: 
	* @param @param args    �趨�ļ� 
	* @return void    �������� 
	* @throws
	 */
	public static void main(String[] args) {
		hotelController.findHotel();
	}
}

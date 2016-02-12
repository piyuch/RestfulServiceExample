package com.task.rest;

/**
 * Simple Pojo to decouple useful data.
 * 
 * @author piyush
 *
 */
public class HotelData {
	
	private String HotelID;
	private String ArrivalDates;
	
	public String getHotelID() {
		return HotelID;
	}
	public String setHotelID(String hotelID) {
		return HotelID = hotelID;
	}
	public String getArrivalDate() {
		return ArrivalDates;
	}
	public String setArrivalDate(String arrivalDate) {
		return ArrivalDates = arrivalDate;
	}
	

}

package com.task.rest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This class is responsible to parse json file and filter required data.
 * 
 * @author piyush
 *
 */

public class RestService {
	
	
	public HotelData parsingJsonAndFilteringData(String param1, String param2, File file) {
		HotelData filteredHotelData = new HotelData();
	    List<String> list = new ArrayList<String>();
	    String arrivalDate = "";
        try {
        	JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(file));
            JSONArray jsonArray = (JSONArray) obj;
            
            arrivalDate=  getArrivalDate(jsonArray,param2);
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> i = jsonArray.iterator();
            
            while (i.hasNext()) {
        	   
        	   JSONObject jsonObject = i.next();
        	   JSONObject jsonObject2 =  (JSONObject) jsonObject.get("hotel");
        	   list.add(jsonObject2.get(param1).toString());      	
          }  
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        filteredHotelData.setHotelID(list.toString());
        filteredHotelData.setArrivalDate(arrivalDate);
		return filteredHotelData;
	}


	private String getArrivalDate(JSONArray jsonArray, String param2) throws JsonGenerationException, JsonMappingException, IOException {
		
		 ArrayList<String> list = new ArrayList<String>();
		 for(int n = 0; n < jsonArray.size(); n++)
         {
             JSONObject object = (JSONObject) jsonArray.get(n);
             JSONArray a = (JSONArray) object.get("hotelRates");
             for(int i = 0; i < a.size(); i++)
             {
               JSONObject jsonObj = (JSONObject) a.get(i);
               list.add(jsonObj.get(param2).toString());
             }   
         }
		 return list.toString();
	}

}

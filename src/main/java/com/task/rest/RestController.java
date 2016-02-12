package com.task.rest;

import java.io.File;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * This Class is responsible to loading the "hotelsrates.json" file 
 * and than invoking the restService to parsing json file and filtering 
 * hotelId and arrivalDate.
 * 
 * FYI: After running the app on the server. please make sure to call the following url:
 * http://localhost:8080/RESTfulTask/rest/json/service/gethotel?param1=hotelID&param2=targetDay
 * 
 * @author piyush
 *
 */

@Path("/json/service")
public class RestController {
	
	/**
	 * 
	 * This method acts as a get rest call that loads the json file and filters the required data.
	 * @param param1 input parameter1 from the browser, i.e. param1 = hotelID
	 * @param param2 input parameter2 from the browser, i.e. param2 = targetDay
	 * @return the json string as a response
	 */
	
	@GET
	@Path("/gethotel")
	@Produces(MediaType.APPLICATION_JSON)
	public HotelData getHotelFilteredInfo(@QueryParam("param1") String param1, @QueryParam("param2") String param2) {
		ClassLoader classLoader = getClass().getClassLoader();
	    File file = new File(classLoader.getResource("hotelsrates.json").getFile());
	    RestService restService = new RestService();
	    HotelData hotelFilteredData= restService.parsingJsonAndFilteringData(param1, param2, file);
	    return  hotelFilteredData;          
    }
	
}
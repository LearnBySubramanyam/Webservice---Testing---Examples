package com.hcl.rest;

import java.util.List;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.hcl.rest.models.CountriesResponse;
import com.hcl.rest.models.Result;
import com.jayway.restassured.response.Response;

public class UsersAPITest {
	MainService service ;
	Response responseData;
	
	@Test
	public void userTest()  {
		service = new MainService();
		responseData = service.getUsers();
		
		Gson gson = new Gson();
		 CountriesResponse data = gson.fromJson(responseData.asString(), CountriesResponse.class);
		 List<Result> resultsList = data.getRestResponse().getResult();
		 for (int i = 0; i < resultsList.size(); i++) {
			 String resultName = resultsList.get(i).getName();
			 System.out.println(" ====== >>>>>  RESULT COUNTY NAME :  "+resultName);
			 System.out.println(" ====== >>>>>  ALPHA 2 CODE :  "+resultsList.get(i).getAlpha3Code());
			 System.out.println(" ====== >>>>>  ALPHA 3 CODE :  "+resultsList.get(i).getAlpha3Code());
		}
		 
		 List<String> data1 = data.getRestResponse().getMessages();
		 for (int i = 0; i < data1.size(); i++) {
			 String resultName = data1.get(i);
			 System.out.println(" ====== >>>>>  RESULT COUNTY NAME :  "+resultName);
			
		}
		
		
	}

}

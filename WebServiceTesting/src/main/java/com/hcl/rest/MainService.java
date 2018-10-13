package com.hcl.rest;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class MainService {

	RequestSpecification resquestSpecification;

	public Response getUsers() {
		resquestSpecification = RestAssured.given();
		Response response = resquestSpecification.get("http://services.groupkt.com/country/get/all");
//		System.out.println(response.asString());

		return response;
	}

}

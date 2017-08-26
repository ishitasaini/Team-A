package com.temp.source.Ishita;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/update")
public class UpdateAddDetails {
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/updateDetails/")

	public Response addDetails(String data, @Context HttpServletRequest request) throws SQLException, JSONException {
		JSONObject JsonObj = new JSONObject(data);
		String username = JsonObj.getString("Username");
		String swift = JsonObj.getString("Swift");
		int accnumber = JsonObj.getInt("AccNumber");
		int contnumber = JsonObj.getInt("ContNumber");
		String postallocation = JsonObj.getString("PostalLocation");
		String postalcity = JsonObj.getString("PostalCity");
		String postalstate = JsonObj.getString("PostalState");
		String factorylocation = JsonObj.getString("FactoryLocation");
		String factorycity = JsonObj.getString("FactoryCity");
		String factorystate = JsonObj.getString("FactoryState");
		String department = JsonObj.getString("Department");
		AdditionalDetails ad = new AdditionalDetails(username,swift, accnumber, contnumber, postallocation, factorylocation, postalcity, factorycity, postalstate, factorystate, department);
		boolean temp;
		temp = AdditionalDetailsDao.insertIntoAdditionalDetails(ad);
		if (temp)
		{return Response.ok("Details updated Successfully").header("Access-Control-Allow-Origin", "*").status(Status.OK).build();
		};
		return Response.serverError().status(Status.EXPECTATION_FAILED).build();
		}




	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/updateProducts/")
	public Response addproducts(String data, @Context HttpServletRequest request) throws SQLException, JSONException {
		JSONObject JsonObj = new JSONObject(data);
		String username = JsonObj.getString("Username");
		JSONArray products = JsonObj.getJSONArray("UserProducts");
//		System.out.println(products.toString());
//		ArrayList<String> prod = new ArrayList<String>();
		String[] prod = new String[products.length()];
//		System.out.println(prod);
		for (int j=0; j<products.length(); j++) {
			prod[j]=(products.get(j).toString());	
		}
		System.out.println(prod[1]);
		System.out.println(username);
		return null;
		
		
		
}
}
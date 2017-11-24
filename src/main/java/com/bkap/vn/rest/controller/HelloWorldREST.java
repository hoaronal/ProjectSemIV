package com.bkap.vn.rest.controller;


import com.bkap.vn.common.entity.Admin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
public class HelloWorldREST {

	@GET
	@Path("/{parameter}")
	public Response responseMsg(@PathParam("parameter") String parameter,
                                @DefaultValue("Nothing to say") @QueryParam("value") String value) {

		String output = "Hello from: " + parameter + " : " + value;

		return Response.status(200).entity(output).build();

	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Admin getEmployee(@PathParam("id") int id,
							 @DefaultValue("No Employee Id passed") @QueryParam("value") String value) {
		System.out.println("getEmployee method is called");
		Admin admin = new Admin();
		admin.setAccount("Quang Hòa");
		admin.setPassword("123456");

		return admin;

	}
	
	@POST
	@Path("/getSalary/{empId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Admin getSalary(@PathParam("empId") int empId,
                              @DefaultValue("No Employee Id passed") @QueryParam("value") String value) {
		System.out.println("getSalary method is called");
		Admin admin = new Admin();
		admin.setAccount("Quang Thuận");
		admin.setPassword("123456");
		
		return admin;

	}

}

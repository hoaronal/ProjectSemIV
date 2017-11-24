package com.bkap.vn.rest.controller;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/user")
public class RestController {

    @GET
    @Path("/list")
    public Response responseMsg() {

        String output = "Hello";

        return Response.status(200).entity(output).build();

    }
}

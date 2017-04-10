package org.cdbookstore.rest;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloEndPoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("method doGet invoked: " + new Date()).build();
	}
}
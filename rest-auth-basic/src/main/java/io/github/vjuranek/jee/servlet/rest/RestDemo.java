package io.github.vjuranek.jee.servlet.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/auth")
public class RestDemo {
	
    @GET
    public String hello() {
		return "hello";
	}
}

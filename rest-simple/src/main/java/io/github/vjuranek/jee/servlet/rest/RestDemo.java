package io.github.vjuranek.jee.servlet.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class RestDemo {
	
    @GET
    public String hello() {
		return "hello";
	}
}

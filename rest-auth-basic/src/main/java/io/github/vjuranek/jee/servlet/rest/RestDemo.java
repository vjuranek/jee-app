package io.github.vjuranek.jee.servlet.rest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("/")
@RolesAllowed({ "admin" })
public class RestDemo {

	@Path("auth")
	@GET
	public String hello() {
		return "hello";
	}

	@Path("ident")
	@GET
	@RolesAllowed({ "admin", "user" })
	public String getIdentity(@Context SecurityContext secCtx) {
		return "Principal name: " + secCtx.getUserPrincipal().getName();
	}
}

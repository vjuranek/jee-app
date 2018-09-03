package io.github.vjuranek.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/session")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "admin" }), httpMethodConstraints = {
		@HttpMethodConstraint(value = "GET", rolesAllowed = { "admin", "user" }),
		@HttpMethodConstraint(value = "POST", rolesAllowed = { "admin" })})
public class SessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();

		out.println("Session ID:" + req.getSession().getId());
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
	}

}

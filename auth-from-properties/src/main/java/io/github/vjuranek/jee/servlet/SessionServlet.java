package io.github.vjuranek.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

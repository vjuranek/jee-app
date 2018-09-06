package io.github.vjuranek.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    
    private AtomicLong gets = new AtomicLong(0);
    private AtomicLong posts = new AtomicLong(0);
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        gets.incrementAndGet();
        
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();

        out.println("Session ID:" + req.getSession().getId());
        out.println("GETs:" + gets.get());
        out.println("POSTs:" + posts.get());
        out.println(Constants.KEY + ": " + req.getSession().getAttribute(Constants.KEY));
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        posts.incrementAndGet();
        
        String val = (String)req.getAttribute(Constants.KEY);
        if (val != null) {
            req.getSession().setAttribute(Constants.KEY, val);
        }
    }
    
}

package io.github.vjuranek.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    
    //private static final int SESSION_EXPIRATION = 30;
    private static final String KEY = "test-key";
    
    private AtomicLong gets = new AtomicLong(0);
    private AtomicLong posts = new AtomicLong(0);
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        gets.incrementAndGet();
        
        //ServletContext ctx = req.getSession().getServletContext();
        //req.getSession().setMaxInactiveInterval(SESSION_EXPIRATION);
        
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();

        out.println("Session ID:" + req.getSession().getId());
        out.println("GETs:" + gets.get());
        out.println("POSTs:" + posts.get());
        out.println(KEY + ": " + req.getSession().getAttribute(KEY));
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        posts.incrementAndGet();
        
        String val = req.getParameter(KEY);
        if (val != null) {
            req.getSession().setAttribute(KEY, val);
        }
    }
    
}

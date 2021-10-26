package com.example.demo.jee.java.hw;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(name = "BasicServlet", urlPatterns = "/hello_world")
public class BasicServlet extends HttpServlet {
    private transient ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            res.getWriter().println("<h1>Hello world from Dmitry!</h1>");
    }

    @Override
    public String getServletInfo() {
        return "BasicServlet";
    }

    @Override
    public void destroy() {
    }

}

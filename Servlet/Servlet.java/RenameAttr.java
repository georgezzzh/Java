package com.example.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RenameAttr extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        synchronized (getServletContext()){
            getServletContext().setAttribute("foo",100);
        }
        PrintWriter writer=response.getWriter();
        writer.println("foo is :"+getServletContext().getAttribute("foo"));
    }
}

package com.example.web;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class PageTest extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        PrintWriter writer=response.getWriter();
        session.setAttribute("foo",42);
        writer.println("create time is: "+new Date(session.getCreationTime()));
        writer.println("<br/>Access the property of Session: foo:"+session.getAttribute("foo"));
        writer.println("<br/>id is: "+session.getId());
        writer.println("<br/>Last Accessed Time is: "+new Date(session.getLastAccessedTime()));
        writer.println("<br/>Max Inactive Interval is: "+session.getMaxInactiveInterval()+"s");
        session.setMaxInactiveInterval(60*60);
        writer.write("<br/>Reset Max InactiveInterval time is "+session.getMaxInactiveInterval()+"s");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        BeerExpert expert=new BeerExpert();
        PrintWriter writer=response.getWriter();
        String color=request.getParameter("color");
        ArrayList result=expert.getBrands(color);
        writer.write("Recommend color list as follow:<br/>");
        for(int i=0,len=result.size();i<len;i++)
        writer.write((String)result.get(i)+"<br/>");
        String[]books=request.getParameterValues("book");
        writer.write("You Select book list as follow:<br/>");
        for(String tmp:books)
            writer.write(tmp+"<br/>");
    }
}

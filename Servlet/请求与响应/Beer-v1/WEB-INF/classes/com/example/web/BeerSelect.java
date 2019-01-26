package com.example.web;
import com.example.model.*;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BeerSelect extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        //response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        //out.println("Beer Selection Advice<br/>");
        String c=request.getParameter("color");
        String body=request.getParameter("body");
        //同一个参数有多个值，需要用数组来获取传来的值
        String[]sizes=request.getParameterValues("beerSize");
        ArrayList arr=new ArrayList();
        for(String s:sizes)
            arr.add(s);
        BeerExpert be=new BeerExpert();
        List result=be.getBrand(c);

        request.setAttribute("color",c);
        request.setAttribute("sizes",arr);
        request.setAttribute("styles",result);
        RequestDispatcher view=request.getRequestDispatcher("index.jsp");
        view.forward(request,response);

    }
}

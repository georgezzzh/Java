package com.example.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieTest extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name=request.getParameter("name");
        Cookie cookie=new Cookie("username",name);
        //设置生存时期为30分钟
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);

        RequestDispatcher view=request.getRequestDispatcher("cookieresult.jsp");
        view.forward(request,response);
    }
}

package com.example.web;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckCookie extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        Cookie []cookies=request.getCookies();
        if(cookies!=null)
        for(Cookie tmp:cookies){
            if(tmp.getName().equals("username")){
                writer.println("Hello: "+tmp.getValue());
                break;
            }
        }
    }
}

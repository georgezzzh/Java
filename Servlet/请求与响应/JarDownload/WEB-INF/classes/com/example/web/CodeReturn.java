package com.example.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class CodeReturn extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{

        response.setContentType("application/jar");
        //获取当前环境
        ServletContext ctx=getServletContext();
        //获取资源
        InputStream is=ctx.getResourceAsStream("/bookCode.jar");
        int read=0;
        byte[]bytes=new byte[1024];
        OutputStream os=response.getOutputStream();
        while((read=is.read(bytes))!=-1){
            os.write(bytes);
        }
        os.close();

    }
}

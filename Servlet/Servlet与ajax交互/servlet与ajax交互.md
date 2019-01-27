###
步骤：页面嵌入js代码，将数据发送到servlet，后台返回json数据。   

        package com.example.web;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.Enumeration;

        public class PageTest extends HttpServlet {
            public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                //修复编码问题
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset=utf-8");

                PrintWriter writer=response.getWriter();
                //需要加上转移字符
                String jsonStr="{\"name\":\"george\",\"info\":\"newworld\"}";
                //返回json数据
                writer.write(jsonStr);
            }
            public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset=utf-8");
                //接受发送来的数据
                String firstName=request.getParameter("firstName");
                System.out.println("firstName: "+firstName);
            }
        }
*需要注意的是地址是'/mypage/index',前面的斜线指的是相对于容器根目录而言。*
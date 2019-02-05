## cookie
最初设计cookie为了帮助支持会话状态，cookie实际就是再客户和服务器之间交换的一小段数据(一个名值String对)，服务器把cookie发送给客户，客户做出下一个请求时再把cookie发送给服务器。  
默认，cookie寿命和session一样长；一旦客户离开浏览器，cookie就会消失；  
### 创建一个新cookie
*Cookie cookie=new Cookie("username",name);*  
### 设置cookie在客户端上存活多久
*cookie.setMaxAge(30*60);*   
### 把cookie发送回客户
*response.addCookie(cookie);*  
### 从请求中得到某个cookie
    Cookie[]cookies=request.getCookies();
    for(Cookie tmp:cookies){
        if(tmp.getName.equals("username")){
            String name=tmp.getValue();
            out.println("Hello: "+name);
            break;
        }
    }
## 简单的cookie例子
cookieTest.java(设置cookie)


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
*CheckCookie.java*(获取设置的cookie)

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
只有addCookie()方法，不存在setCookie();  

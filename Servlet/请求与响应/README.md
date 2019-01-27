*在两个demo中classes中有.java文件可以参考*  
### HttpServlet
HttpServlet有一个匹配`doXXX()`的方法。
>Http的请求方法有：POST,GET,HEAD,TRACE,OPTIONS,PUT,DELETE,CONNECT   

**POST和GET的区别在于,POST将请求参数防止在请求体中，而GET直接附加在url参数后面**     

1. 简单的超链接方法是*GET*。如果在表单没有指明`method=POST`,默认是HTTP GET请求。  

### HttpServlet中的方法 
* `String client=request.getHeader("User-Agent");`
* `Cookie[] cookies=request.getCookies();`
* `HttpSession session=request.getSession();`
* `String theMethod=request.getMethod();`  
* `InputStream input=request.getInputStream();`

2. 可以用 *getParameter("paramname")* 方法从请求得到参数。返回值是一个String。  
3. 如果对应一个给定的参数名有多个参数值，要使用 *getParameterValues("paramname")* 方法来返回一个String数组。  
> servlet提供了两种可选的流，ServletOutStream用于输出字节，PrintWriter用于输出字符数据。
### getHeader()
由于HttpServletRequest是一个接口，需要web容器来实例化这个接口
>//浏览器平台和浏览器信息  
String client=request.getHeader("User-Agent");  
//请求Cookie  
Cookie[]cookie=request.getCookie();  
//与客户相关的会话  
HttpSession session=request.getSession();  
//请求的Http方法  
String theMethod=request.getMethod();  
//请求的输入流  
InputStream input=request.getInputStream();

### PrintWriter
>PrintWriter writer=response.getWriter();  
writer.println("一些字符");
### OutputStream
该方法输出二进制流。
> ServletOutputStream out=response.getOutputStream();  
out.write(ByteArray);

写字节可以写任何内容   
### setContentType()
该方法告诉浏览器如何处理相应到来的数据。常见的MIME类型有”text/html","application/pdf"等。

        //相应一个jar文件下载
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

### Servlet重定向&文件路径
>`response.sendRedirect("https://www.baidu.com");`Http相应中状态是301为重定向。  

在sendRedrect()可以使用绝对URL，也可以使用相对URL，相对URL有两种类型，前面有斜线("/")和没有斜线。   
1. 假如原来用户键入的是`https://www.baidu.com/myApp/bar.do`,请求bar.do的Servlet时，这个servlet会调用一个相对URL来调用sendRedirect()，这个相对URL没有用斜线开头`sendRedirect("foo/stuff.html")`。容器会相对于原先请求URL建立完整的URL，需要把他放在HTTP相应的”location“首部中。新的绝对URL是`https://www.baidu.com/myApp/foo/stuff.html`。
2. 如果sendRedirect()的参数确实以一个斜线开头：`sendRedirect("/foo/stuff.html")`,容器会相对于Web应用本身建立完整的URL，而不是相对于请求原来的URL，所以新的URL是`https://www.baidu.com/foo/stuff.html`。

如果在相应已经提交之后再调用重定向，会抛出一个IllegalException。在Servlet中必须决定，要么处理请求，要么调用sendRedirect()让别人来处理请求。(即，如果已经向刘中写了东西，再重定向就太晚了。)  
3. sendRedrect()的参数是一个String，而不是一个URL对象。  

**重定向与请求分配有所区别。使用jsp是请求分派。**

### Q1. What is the exact difference between out.write() and out.print()?
Detail: In my Servlet I gave both `out.print` and `out.write`,but both print in browser.  
A1:  
1. The base difference is that `out.write()` explodes if you pass it a null;
> String s=null;
out.print(s);//outputs the text null
out.write(s);//NullPointerException
2. `out.print()`can print Boolean values but `out.write()` can not;
> boolean b=true;  
out.write(b); //compilation error  
out.print(b);//'true' will be printed
3. if you are using `out.write()`, you simply can not place arithmatic operation code but `out.print()` provides the supports.  
>out.print(10+20);//No output will be display  
out.print(10+20);//Output '30' will be displayed
### Q2. encodeRedirectURL()和encodeURL()的区别  
1. encodeURL()方法用在servlet输出，例如输出a标签
2. encodeRedirectURL()用在重定向中*response.sendRedirect()*中，例如*response.sendRedirect(response.encodeRedirectURL("attr"));* 
>*encodeURL()* is used for all URLs in a servlet's output. It helps session ids to be encoded with the URL.  
*encodeRedirectURL()* is used with res.sendRedirect only. It is also used for encoding session ids with URL but only while redirecting.
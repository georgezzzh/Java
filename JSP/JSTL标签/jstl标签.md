## 使用JSTL
### c-forEach标签
1. servlet代码    

        String[]movieList={"mov","the auther king","the way to the west"};
        request.setAttribute("movieList",movieList);
        request.forward("/basicJsp.jsp");
2. jsp代码

        <!--声明jstl的使用-->
        <%@taglib uri="http://java.sun.com/jsp/jstl/core"%>

        <table>
        <c:forEach var="movie" items="${movieList}">
        <tr>
        <td>${movie}</td>
        </tr>
        </c:forEach>
        </table>
异常`The absolute uri: http://java.sun.com/jsp/jstl/core cannot be resolved in either web.xml`   
**<h3>solution:</h3>**下载<a href="http://repo2.maven.org/maven2/javax/servlet/jstl/1.2/">jstl包下载地址</a>,添加到tomcat\lib下即可。
### for-Each中的计数器
    <c:forEach var="movie" items="${movieList}" varStatus="LoopCount">
    <tr>
    <td>${LoopCount.count}</td>
    </tr>
    </c:forEach>
### 嵌套forEach循环
嵌套循环用于处理一个List,其中每一项又是一个数组的内容

1. servlet代码

        String[]musicList1={"zero7","Tahiti 80","BT","Frou Frou"};
        String[]musicList2={"Matrix","Kill Bill","Boondock Saints"};
        ArrayList musicList=new ArrayList();
        musicList.add(musicList1);
        musicList.add(musicList2);
        request.setAttribute("musicList",musicList);
2. jsp代码    


       <table>
	   <c:forEach var="musicArray" items="${musicList}">
		<c:forEach var="movie" items="${musicArray}"  varStatus="LoopCount">
			<tr>
			<td>Count: ${LoopCount.count}</td>
			<td>${movie}</td>
			</tr>
		</c:forEach>
	   </c:forEach>
	    </table>
## c:if标记
检测属性，若name==“george”，则显示comment.html页面，否则不显示。

	   <!--条件包含模块-->
	   <c:if test="${name eq 'george'}">
	   <jsp:include page="comment.html"/>
	   </c:if>	
## c:choose标记和它的同伴c:when, c:otherwise
    	<!--c:choose模块--->
	   <b>shooping advise</b>
	   <c:choose>
		<c:when test="${pref=='performance'}">
		<p>Now You can stop even if you do drive insanely fast.</p>
		</c:when>
		<c:when test="${pref=='safety'}">
		<p>Our breaks will never lock up,no matter how bad a driver you are.</p>
		</c:when>
		<c:otherwise>
		<p>Our breaks are the best</p>
		</c:otherwise>
	   </c:choose>
*注: 在判断是否相等时==和eq都可以*
## c:remove标记
		<!--测试c:remove标记-->
		<p>未删除之前</p>
		<p>name:${name}</p>
		<c:remove var="name" scope="request"/>
		<p>Now name is: ${name}</p>
scope是可选的，默认为page作用域
## c:import标记
		<!--测试c:import标记-->
		<c:import url="https://www.baidu.com" charEncoding="UTF-8"/>
*使用`<jsp:include>`或者include指令只能包含当前web应用的页面，`<c:import>可以将容器之外的内容拿过来。`*   
## c:import定制包含的内容
		<!--定制标记模块-->
		<c:import url="footer.jsp">
			<c:param name="title" value="We take the sting out of soap."/>
		</c:import>
2. footer.jsp


        <strong>${param.title}</strong>
## c:url超链接
		<!--jsp中url重写-->
		<a href="<c:url value='/input.jsp'/>">click here</a>
## c:url编码
	<c:set var="first" value="Hidden Cursor"/>
	<c:set var="last" value="Crouching Pixels"/>
	<p>The URL is: 
	<c:url value="/input.jsp">
	<c:param name="firstname" value="${first}"/>
	<c:param name="lastname" value="${last}"/>
	</c:url>
URL编码意思是，将不安全的保留字符替换为其他字符，然后再服务器端完成解码，例如URL中不允许出现空格，用"+"来代替空格。   
## 建立错误页面
1. 指定的错误页面errorPage.jsp

        <%@page isErrorPage="true" %>
        <html>
        <body>
        <p>Error!!!!</p>
        </body>
        </html>
2.     

    <%@page errorPage="./errorPage.jsp"%>
## 在DD中配置错误页面
1. 根据一个HTTP状态码声明错误页面    

        <error-page>
        <error-code>404</error-code>
        <location>/notFoundError.jsp</location>
        </error-page>
2. 声明一个"普遍"类型的错误页面    

        <error-page>
            <exception-type>java.lang.Throwable</exception-type>
            <location>/errorPage.jsp</location>
        </error-page>
3. 声明一个更明确的错误页面    

        <error-page>
            <exception-type>java.lang.ArithmeticException</exception-type>
            <location>/errorPage.jsp</location>
        </error-page>

<%@page import="java.util.*"%>
<!--加上这句，防止乱码，UTF需要大写-->
<!--指定错误页面-->
<%@page contentType ="text/html;charset=UTF-8" errorPage="./errorPage.jsp"%>

<!--需要声明标签,要把jstl的标签保存到tomcat的lib中-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--包含页眉-->
<%@ include file="./header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="utf-8">
	</head>
    <body>
       <p>Upload data is:</p> 
	   
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
	   <!--c:choose模块--->
	   <b>shooping advise</b>
	   <c:choose>
		<c:when test="${pref eq 'performance'}">
		<p>Now You can stop even if you do drive insanely fast.</p>
		</c:when>
		<c:when test="${pref=='safety'}">
		<p>Our breaks will never lock up,no matter how bad a driver you are.</p>
		</c:when>
		<c:otherwise>
		<p>Our breaks are the best</p>
		</c:otherwise>
	   </c:choose>
	   <!--条件包含模块-->
	   <c:if test="${name eq 'george'}">
	   <jsp:include page="comment.html"/>
	   </c:if>
		<!--测试c:remove标记-->
		<p>未删除之前</p>
		<p>name:${name}</p>
		<c:remove var="name" scope="request"/>
		<p>Now name is: ${name}</p>
		<!--测试c:import标记-->
		<!--
		c:import url="https://www.baidu.com" charEncoding="UTF-8"
		-->
		<!--定制标记模块-->
		<c:import url="footer.jsp">
			<c:param name="title" value="We take the sting out of soap."/>
		</c:import>
		<!--jsp中url重写-->
		<a href="<c:url value='/input.jsp'/>">click here</a>
		<!--jsp中url编码-->
		<c:set var="first" value="Hidden Cursor"/>
		<c:set var="last" value="Crouching Pixels"/>
		<p>The URL is: 
		<c:url value="/input.jsp">
		<c:param name="firstname" value="${first}"/>
		<c:param name="lastname" value="${last}"/>
		</c:url>
		<!--制造错误页面-->
		<!--%int x=10/0;%
		-->
		</p>
    </body>
</html>

















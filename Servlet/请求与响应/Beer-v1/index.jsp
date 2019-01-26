<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 19/1/25
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@page import="java.util.*" %>
<html charset="utf-8">
<head>
    <title>Title</title>
</head>
<body>
<h1>Beer Recommendations JSP</h1>
<%
out.print("color: "+request.getAttribute("color"));
List styles=(List)request.getAttribute("styles");
Iterator it=styles.iterator();
while (it.hasNext()){
    out.print("<br>ADVICE: "+it.next());
}
List sizes=(List)request.getAttribute("sizes");
it=sizes.iterator();
while(it.hasNext()){
	out.print("<br/>size: "+it.next());
}

%>
</body>
</html>

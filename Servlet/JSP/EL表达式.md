## El表达式
使用El，可以很轻松地打印性质的性质    

    //打印person对象的dog对象的name属性
    ${person.dog.name}
需要在servlet中对request设置属性  
    
    request.setAttribute("person",person);
EL表达式总是放在大括号里，而且前面有一个美元符前缀。  
*使用.(dot符号)时，需只有当右边时左边的一个bean性质或映射键时，点号操作符才能工作。*  
## 使用 **[]** 符号
    ${person["name"]}于${person.name}等价
[]有了更多的选择，除了Map和Bean之外，还可以操作数组和List。  
`[]`中的String索引会强制转换为int型。利用`[]`可以访问ArrayList。  
### 使用EL提取表单的提交数据
HTML表单  

    <form action="basicJsp.jsp">
    <input type="text" name="name">
    <input type="text" name="empID">
    </form>
JSP处理  

        request param name is: ${param.name}
        request param empID is: ${param.empID}
### 处理隐式对象
获取服务器的主机信息,由请求的host首部提供    

        host is: ${header["host"]}
        //调用的requestScope对象
### 调用pageContext作用域
    Method is:  ${pageContext.request.method}
pageContext有一个Request的性质
### 调用Cookie作用域
    ${cookie}
### 打印上下文初始化参数
尽管在web.xml中配置是     

    <context-param>
        <param-name>mainEmail</param-name>
        <param-value>usasne@163.com</param-value>
    </context-param>
在jsp中el表达式如下     

    email is: ${initParam.mainEmail}
    //这里不是使用的contextParam。。。
### EL中的include动作
    <jsp:include page="header.jsp">
### 使用include指令
    <%@ include file="header.jsp" %>
>使用include标准动作与include指令的区别:   
include标准动作，在运行时把另一个jsp页面包含进来；  include指令，在转换时发生。 

*不要把开始和结束HTML和BODY标记放在可重用部件中，设计和编写布局模块组件时(如页眉，导航条)，要假设他们会包含在其他页面中。*
### jsp转发
    <html>
    <body>
    welcome page
    <% if(request.getParameter("userName")==null){%>
    <jsp:forward page="Handle.jsp">
    
    <%}%>
    </body>
    </html>

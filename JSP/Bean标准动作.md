# bean标准动作
## jsp:useBean
## jsp:getProperty
servlet中代码 

```java
Person george=new Person();
george.setName("george");
request.setAttribute("person",george);
request.forward("/result.jsp");
```
jsp中获取Person的name属性代码   

    //用jsp:useBean声明和初始化一个Bean属性
    //id对应于servlet中setAttribute("person",george);中的person
    //class填写完全限定名
    //scope标识bean对象的属性作用域
    <jsp:useBean id="person" class="foo.Person" scope="request"/>
    
    //用jsp:getProperty得到bean属性的性质值
    //name对应于jsp:useBean中的id，property对应于person对象中的name属性
    <jsp:getProperty name="person" property="name"/>
*如果jsp:useBean找不到一个名为"person"的属性对象，它就会创建一个。*
## jsp:setProperty
```xml
<jsp:useBean id="person" class="foo.person" scope="request>
<jsp:setProperty name="person" property="name" value="fred">
```
使用jsp:setProperty来设置bean的性质
*可以使用`<jsp:useBean>`有条件的设置性质，只有在创建新的bean时才会设置性质值。如果发现对于指定的scope和id已经存在一个bean，就不会运行jsp:use-Bean标记中的体*    

```xml
<jsp:useBean id="person"  class="foo.Person" scope="page">
<jsp:setProperty name="person" property="namee" value="Fred">
</jsp:useBean>
```

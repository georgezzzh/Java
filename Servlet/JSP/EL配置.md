### EL(Expression Language)表达式语言
>EL的用途是提供一种更简单的方法来调用Java的代码，但是代码本身放在别的地方，按照最佳实践，不能再JSP中编写方法代码，要把Java方法卸载别的地方，再用EL来调用。

### 在jsp中禁止使用脚本元素(在DD中配置)
    <!--jsp中禁止使用scriptlet-->
    <jsp-config>
    <jsp-property-group>
    <url-pattern>*.jsp</url-pattern>
    <scripting-invalid>true</scripting-invalid>
    </jsp-property-group>
    </jsp-config>
### 在jsp中禁止使用EL表达式(DD中配置)
    <!--jsp中禁止使用EL-->
    <jsp-config>
    <jsp-property-group>
    <url-pattern>*.jsp</url-pattern>
    <!--忽略El表达式-->
    <el-ignored>true</el-ignored>
    </jsp-property-group>
    </jsp-config>
或者在page中配置    

    <%@ page isElIgnored="true" %> 
### EL表达式会放在服务方法中。
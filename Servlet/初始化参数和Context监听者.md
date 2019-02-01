### Servlet初始化参数
Servlet初始化参数只能读一次，在容器初始化Servlet时读取。  
在**web.xml**中配置init-param  

        <web-app>
        <servlet>
        <init-param>
        <param-name>adminEmail</param-name>
        <param-value>usasne@163.com</param-value>
        </init-param>
        </servlet>
        </web-app>
#### **该初始化参数只能在指定的类中访问，如果让整个应用都可以访问。** 
在Servlet中获取  

    out.println("adminEmail:"+getServletConfig().getInitParameter("adminEmail"));
    //可以用枚举类来遍历Servlet-name
    Enumeration e=getServletConfig().getInitParameterNames();
    while(e.hasMoreElements()){
        out.println("param name:"+e.nextElement());
    }
### 上下文初始化参数context-param
### **上下文初始化参数对整个Web应用而不是一个servlet可用。**   
配置web.xml文件   

        <web-app>
        <servlet>
                <servlet-name></servlet-name>
        </servlet>
        <!--context-para不用包含在servlet中-->
        <context-param>
                <param-name>adminEmail</param-name>
                <param-value>usasne@163.com</param-value>
        </context-param>
        </web-app>
在servlet中的代码  

    out.println(getServletContext().getInitParameter("adminEmail"));
OR

    ServletContext context=getServletContext();
    out.print(context.getInitParameter("adminEmail"));
 区别:  
 每个Servlet一个ServletConfig  
 每个Web应用用一个ServletContext  
 ## 监听者
由于上下文参数(Context)只能是String，如果让web应用所有部分都能访问一个共享的对象，需要用一个监听者(Listener)，在应用启动时，用描述文件初始化一个对象。  
### 一个简单的监听者例子
目标是初始化一个Dog对象 
1. MyServletContextListener.java

        public class MyServletContextListener implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent event) {
                ServletContext sc=event.getServletContext();
                String dogBreed=sc.getInitParameter("breed");
                Dog d=new Dog(dogBreed);
                System.out.println("d's breed: "+d.getBreed());
                //设置一个dog属性，值是一个Dog对象
                sc.setAttribute("dog",d);
        }
        public void contextDestroyed(ServletContextEvent e){
                //donothing
        }
        }
2. Dog.java

        package com.example.web;
        public class Dog {
        private String breed;
        public Dog(String b){
                breed=b;
        }
        public String getBreed(){
                return breed;
        }
        }
3. PageTest.java

        Dog d=(Dog)getServletContext().getAttribute("dog");
        writer.println("Dog's breed is: "+d.getBreed());
4. web.xml

        <!--初始化context参数-->
        <context-param>
        <param-name>breed</param-name>
        <param-value>Great Dane</param-value>
        </context-param>
        <!--定义监听者-->
        <listener>
        <listener-class>
        com.example.web.MyServletContextListener
        </listener-class>
        </listener>
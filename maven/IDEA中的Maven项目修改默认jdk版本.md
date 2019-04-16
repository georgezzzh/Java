## IDEA中的MAVEN项目

IDEA中新建maven项目，jdk默认是jdk5，jdk5太老了，会有一大堆错误。

### 1.首先到maven中的conf目录下的**settings.xml**中配置

在profiles节点下添加如下代码

```xml
 <profile>  
    <id>jdk11</id>  
    <activation>  
        <activeByDefault>true</activeByDefault>  
        <jdk>1.11</jdk>  
    </activation>  
    <properties>  
        <maven.compiler.source>1.11</maven.compiler.source>  
        <maven.compiler.target>1.11</maven.compiler.target>  
        <maven.compiler.compilerVersion>1.11</maven.compiler.compilerVersion>  
    </properties>   
   </profile> 
```

保存

### 2.在IDEA应用新的maven配置

IDEA-->Setting-->maven--->User setting file-->

默认的是`.m2\settings.xml`，打开目录发现并没有，然后把maven/conf/settings.xml复制到指定目录，即可

![例图](https://github.com/georgezhou314/imageRepo/raw/master/IDEA%E4%BD%BF%E7%94%A8/maven1.png)

### 3. 然后就生效了

因为settings.xml中配置了仓库的位置，所以Local repository会更新为配置的仓库名。




修改maven的配置文件，达到每次在IDEA新建项目时候，默认编译Java版本是1.8+

![IDEA修改maven](https://github.com/georgezzzh/resource/raw/master/IDEA/maven1.png)



在IDEA中User Settings file中显示的目录，也就是`/home/george/.m2/settings.xml`配置文件中修改。

主要是修改其中的profile, 设定编译的jdk版本。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
   <profiles>
          <profile>
            <id>jdk</id>
            <activation>
                  <activeByDefault>true</activeByDefault>
                  <jdk>1.8</jdk>
            </activation>
            <properties>
                  <maven.compiler.source>1.8</maven.compiler.source>
                  <maven.compiler.target>1.8</maven.compiler.target>
                  <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
            </properties>
          </profile>
  </profiles>
</settings>

```




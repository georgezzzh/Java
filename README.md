## JDK环境变量配置
<a href="https://www.icourse163.org/learn/ECNU-1002842004#/learn/content?type=detail&id=1005128620&sm=1">windows下Jdk的配置</a>

## Java API

<a href="https://docs.oracle.com/javase/9/docs/api/index.html?overview-summary.html">英文API</a>

<a href="http://tool.oschina.net/apidocs/apidoc?api=jdk-zh">中文API</a>

### ClassPath的问题

在命令行运行*.class文件经常遇到，找不到主类的情况

>错误: 找不到或无法加载主类 public.Convert
>原因: java.lang.NoClassDefFoundError: Convert (wrong name: public/Convert)

* 指定classpath
```
# 指定类搜索路径为public文件夹
java -cp public Convert
```

* 运行java -jar运行jar，指定-cp无效

```
# 曲线救国的方式，指定jar文件路径，运行Main类
java -cp public/LinkGenerage.jar Main
```


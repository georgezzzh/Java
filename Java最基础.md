## Java  基础
### 命令行编译java文件
配置好环境变量后，执行编译时，切换到当前目录，例如  

        cd C:\Users\geoge\Desktop
        javac example.java
        java example

### Java API

<a href="https://docs.oracle.com/javase/9/docs/api/index.html?overview-summary.html">英文API</a>

<a href="http://tool.oschina.net/apidocs/apidoc?api=jdk-zh">中文API</a>


## 源文件命名
如果一个Java源文件里定义的所用类都没有使用public修饰，则这个Java源文件的文件名可以是一切合法的文件名。但是如果一个java源文件里定义了一个Public修饰的类，则这个源文件的文件名必须与public修饰的类的类名相同。
## 包的概念package
Java使用包来管理一些类   
![5Wrbih.png](https://s1.ax2x.com/2018/12/27/5Wrbih.png)   
目录应该这样放置。然后在该JUMP文件夹下的JUMP.class下包含包的声明`package JUMP;`就形成了一个包。  
在Main类中开头`import JUMP.*`就导入了JUMP包中全部的类了  
**号代表这个目录下的所有的文件，不包括子文件夹和子文件夹中文件夹*  
*如果类源文件在同一个文件夹下，不写import也可以*  
*import必须全部放在package之后，类定义之前，多个import顺序无关*

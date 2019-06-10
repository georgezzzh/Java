7个级别日志记录器级别

* SEVER
* WARNING
* INFO
* CONFIG
* FINE(详细)
* FINER(较详细)
* FINEST(非常详细)

默认情况下，只记录前三个级别。如果将记录级别设计为INFO或者更低，需要修改日志处理器的配置，默认日志处理器不会处理低于INFO级别的信息。

### 修改日志配置

`jdk-11.0.2/conf/logging.properties`    

```properties
# 增加如下配置，FileHandler可以随意的调整level,ConsoleHander的level被properties定义好了
# 如果想把ConsoleHander的Level调整
# 需要修改50行左右的java.util.logging.ConsoleHandler.level=ALL或者其他内容
myLogger.handlers= java.util.logging.ConsoleHandler, java.util.logging.FileHandler
myLogger.level= ALL
```
### 日志处理器

日志API提供了两个重要的处理器，一个是FileHandler，一个是SocketHander，SocketHander将记录发送到特定的主机和端口。

* **一个输出到文本文件的日志记录Demo**

*LoggerStart.java*日志记录类

```java
package com.sonydafa;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.logging.*;

public class LoggerStart {
    //private static final Logger myLogger=Logger.getLogger("com.sonydafa");
    //在logging.properties中配置的处理器
    private static final Logger myLogger=Logger.getLogger("myLogger");
    public static void main()  throws IOException{
        myLogger.setUseParentHandlers(false);
        //桌面路径
        String deskPath=FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
        File file=new File(deskPath+"//log.txt");
        boolean createLogFileFlag = file.createNewFile();
        //增加文件日志处理器
        FileHandler fileHandler = new FileHandler(file.getAbsolutePath());
        fileHandler.setFormatter(new SimpleFormatter());
        myLogger.addHandler(fileHandler);
        //记录日志
        myLogger.info("myLogger begin log something");
        myLogger.entering("com.sonydafa.LoggerStart","main");
        //{0}为占位符
        myLogger.log(Level.INFO,"param test {0} {1}",new Object[]{"param1","param2"});
        myLogger.info("log path is: "+file);
        myLogger.severe("severe");
        myLogger.warning("warning");
        //以下日志默认不会记录
        myLogger.config("config");
        myLogger.fine("fine");
        myLogger.finer("finer");
        myLogger.finest("finest");
        myLogger.logp(Level.INFO,"com.sonydafa.LoggerStart","main","log p");
        try{
            throw new IOException();
        }
        catch (IOException e){
            //throw是finer等级的日志
            myLogger.throwing("com.sonydafa.LoogerStart","main",e);
        }
        myLogger.exiting("com.sonydafa.LoggerStart","main");
    }
}

```

Main.java启动类

```java
import com.sonydafa.LoggerStart;

import java.io.IOException;

public class Start{
    public static void main(String[]args) {
        try {
            LoggerStart.main();
            //生成的日志可以查看log.txt
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```


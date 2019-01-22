### IDEA导出jar包  
*用GitHub导出图片时，把链接中的blob换成raw*
1. 在IDEA的菜单中选择File–>Project Structure,如下图所示：
<img src="https://github.com/Geogechou/imageRepo/raw/master/IDEA%E4%BD%BF%E7%94%A8/jar1.png"/>  
2. 选择“Artifacts“在出现的图中点击加号  
![](https://github.com/Geogechou/imageRepo/raw/master/IDEA%E4%BD%BF%E7%94%A8/jar2.png)  

3. 在如下的图形中需要注意两个地方：
![](https://github.com/Geogechou/imageRepo/raw/master/IDEA%E4%BD%BF%E7%94%A8/jar3.png)    

* 需要选择jar包默认运行的入口类 
* 需要设置MANIFEST.MF的位置，在选择好入口类后系统会将MANIFEST.MF默认放在src/main/java下，需要将其放在/src/main/resources下

点击确认后，我们可以看一下MANIFEST.MF中内容
>Manifest-Version: 1.0  
Main-Class: com.test.MAIN  

* 继续点击Build–>Build Artifacts

![](https://github.com/Geogechou/imageRepo/raw/master/IDEA%E4%BD%BF%E7%94%A8/jar4.png)    

继续如下的操作  
![](https://github.com/Geogechou/imageRepo/raw/master/IDEA%E4%BD%BF%E7%94%A8/jar5.png)     

上述步骤后，你会在相应工程的目录下看到一个名称为out的文件夹。其中可以找到对应的jar文件，比如本次的mqproducer.jar

将生成的jar包拷贝到需要的地方，使用如下运行即可：

java -jar mqproducer.jar
1. 如果入口类需要参数只需要在命令后面加参数以空格分割即可，如：

`java -jar mqproducer.jar args0 args1 args2`  
2. 常见问题
    本地执行java -jar出现下面的错误   
`Error: Invalid or corrupt jarfile xxx.jar`  
1. 通常的原因在于xxx.jar文件过大，建议在pom.xml文件中排除不必要的依赖

2. 备注：Jar文件在传输过程中损坏也会导致该错误[vServer Linux - Start jar: Invalid or corrupt jarfile]
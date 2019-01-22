## Java  基础
### 命令行编译java文件
配置好环境变量后，执行编译时，切换到当前目录，例如  

        cd C:\Users\geoge\Desktop
        javac example.java
        java example

### Java API

<a href="https://docs.oracle.com/javase/9/docs/api/index.html?overview-summary.html">英文API</a>

<a href="http://tool.oschina.net/apidocs/apidoc?api=jdk-zh">中文API</a>

#  2. String 对象

1）静态方式----采用直接赋值方法

String str="abc";

2)动态方式----使用new动态分配内存方式

String str=new String("abc");

## 两个string对象比较

    String str1="abc";
    String str2=new String("abc);
    System.out.print(str1==str2);
    //false
    //==是进行数值比较或者地址比较，应该用String.equals()方法来进行比较
    System.out.print(str1.equals(str2));


##  3.  Random()类

    import java.util.Random
    Random generator=new Random();
    //生成0-9的随机数，包含9
    //如果想生成5-9的树，直接generator.nextInt(10)+5;即可
    int num1=generator.nextInt(10);
    float num2=generator.nextFloat();



方法

> Raddom()  //构造方法，创建一个伪随机数生成器
>
> flaot nextFloat()  //返回一个分布在[0.0,1.0]区间的浮点随机数
>
> int nextInt();    //返回一个整形随机数，取值为整个int型区间
>
> int nextInt(int num);  //返回一个整形随机数，取值分布在0--(num-1)区间


## Random类

        Random generator=new Random();
        int num1=generator.nextInt(10);
        float num2=generator.nextFloat();
        System.out.println(num1+" "+num2);

## Scanner类


    Scanner scan1=new Scanner(System.in);
    System.out.println("请输入String类数据: ");
    String str=scan1.next();
    System.out.println(str);
    int i=scan1.nextInt();
    System.out.println(i);
## 源文件命名
如果一个Java源文件里定义的所用类都没有使用public修饰，则这个Java源文件的文件名可以是一切合法的文件名。但是如果一个java源文件里定义了一个Public修饰的类，则这个源文件的文件名必须与public修饰的类的类名相同。
## 包的概念package
Java使用包来管理一些类   
![5Wrbih.png](https://s1.ax2x.com/2018/12/27/5Wrbih.png)   
目录应该这样放置。然后在该JUMP文件夹下的JUMP.class下包含包的声明`package JUMP;`就形成了一个包。  
在Main类中开头`import JUMP.*`就导入了JUMP包中全部的类了  
**号代表这个目录下的所有的文件，不包括子文件夹和子文件夹中文件夹*

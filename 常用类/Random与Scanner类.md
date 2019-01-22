### 两个string对象比较

    String str1="abc";
    String str2=new String("abc);
    System.out.print(str1==str2);
    //false
    //==是进行数值比较或者地址比较，应该用String.equals()方法来进行比较
    System.out.print(str1.equals(str2));


##  2.  Random()类

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


        Random generator=new Random();
        int num1=generator.nextInt(10);
        float num2=generator.nextFloat();
        System.out.println(num1+" "+num2);

## 3.Scanner类


    Scanner scan1=new Scanner(System.in);
    System.out.println("请输入String类数据: ");
    String str=scan1.next();
    System.out.println(str);
    int i=scan1.nextInt();
    System.out.println(i);

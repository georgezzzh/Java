类常量
```java
public class Constans2{
      public static final double CM_PER_INCH=2.54;
}
```
## String  
   * ==这个运算符检测两个字符串，只能确定两个字符串是否放在同一个位置上。只有字符串常量是共享的，而+或者substring灯操作产生的结果并不是共享的。建议使用equals方法  

     ==, 检测是否引用相等

   *  codePointAt()方法，返回对应位置的编码数字，例如'A'返回65等

```java
//采用unicode编码的字,\u2122是™
String str="Java\u2122";
//all的输出结果是S/M/L/
String all=String.join("/","S","M","L");
//输出其编码的数字
String greeting="hello世界";
for(int i=0;i<greeting.length();i++){
    int n=greeting.codePointAt(i);
    System.out.println("n="+n);
}
```

   *  compareTo(String another);
      

```java
    //这个方法是compareTo()的一个实现，返回负数就表示str1比str2小，返回正数就是str1比str2大，返回0表示一样大。  
    private static int compareToUTF16Values(byte[] value, byte[] other, int len1, int len2) {
            int lim = Math.min(len1, len2);
            for (int k = 0; k < lim; k++) {
                char c1 = getChar(value, k);
                char c2 = StringUTF16.getChar(other, k);
                if (c1 != c2) {
                    return c1 - c2;
                }
            }
            return len1 - len2;
        }
```
StringBuffer和StringBuilder的区别，StringBuilder的前身是StringBuffer，StringBuffer允许不同的线程修改增加字符串。

## System

获取系统变量

```java
//其中有user.dir和java.io.tmpdir等许多变量
Properties pr=System.getProperties();
Object objects[]=pr.entrySet().toArray();
for(Object ob:objects)
	System.out.println(ob);
```

## 退出多层循环

```java
onestep:
for(int i=0;i<10;i++)
    for(int j=0;j<10;j++){
        System.out.println(i+" & "+j);
        if(i*j==49)
            break onestep;
    }
```

## BigInteger

java.math包中的大数类

```java
BigInteger b1=new BigInteger("1234599877712233213123113");
BigInteger b2=new BigInteger("89289366988231245588748793");
BigInteger sum=b1.multiply(b2);
```
## 数组

* 数组拷贝

    ```java
    int[]luck={1,2,3,4,5};
    //指定源头和拷贝的长度，超出补0
    int[]another= Arrays.copyOf(luck,luck.length+2);
    //输出为[1,2,3,4,5,0,0],Arrays.toString()把所有元素转换为字符串输出
    System.out.println(Arrays.toString(another));
    ```

* 所有元素统一赋值

  `Arrays.fill(type[]type,type value);`, 将数组中所有元素全部设置为value
  
* 用*deepToString()*将数组转换为字符串

    ```java
    int[][]arr=new int[10][5];
    //fill只能针对一维数组
    Arrays.fill(arr[0],1);
    System.out.println(Arrays.deepToString(arr));
    ```

## 面向对象

* 如何需要返回一个可变数据域的拷贝，就应该试用clone

  ```java
  public class Employee {
      private String name;
      private Date birth;
      public Date getBirth(){
          //返回一个对象的clone数据
          return (Date)birth.clone();
      }
  }
  ```

* 静态常量

  ```java
  public class Math{
      public static final double PI=3.1415926535;
  }
  ```

* 静态方法的试用场景

  * 一个方法不需要访问对象状态，其所需参数通过显示参数提供(例如Math.pow());
  * 一个方法只需要访问类的静态域

* 工厂方法

  类似LocalDate的类使用静态工厂方法来构造对象。

  不适用构造器的原因，1. 构造器的名字必须与类命相同。2. 使用构造器时，无法改变构造的对象的类型。
  
* 包

  Sun公司建议将公司的因特网域名以逆序的形式作为包名，例如com.horstmann

  `import static java.lang.System.out`，导入特定的方法或域

## Doc注释

* 类注释

    ```java
    /**
    *A {@code val} anyway write something
    */
    ```
    
    @code是写等宽代码的，而不用`<code></code>`标记
    
* 方法注释

  ```java
  /**
   * get birthday of an employee
   * @param t there is non sense
   * @return return a date object, but it's a clone object
   * @throw throw nothing
   */
  public Date getBirth(int t){
      return (Date)birth.clone();
  }
  ```

  @param是方法的入参，@return是方法返回的参数，@throw是方法可能抛出的异常

## 继承

java子类继承父类时，尽管继承了父类的所有私有属性，但是无法直接访问，需要接用getXxx()和setXxx()接口来访问。

* 抽象类

  抽象类含有未实现的方法，仅有声明未有实现，由子类来实现。抽象类无法实例化。

* protected关键词

  protected关键词，允许子类访问父类的protected属性和方法。如何需要限制某个方法的使用，可以将其声明未protected，这表明子类得到信任，可以正确地使用这个方法，而其他类不行。

  protected还允许本包可见。

## Object

* equals()

  object中equals()方法，如果两个对象指向同一块 存储区域，方法返回true，否则返回false；

## 可变参数个数的方法

```java
public static void print(String...args)
{
    for(int i=0;i<args.length;i++)
        System.out.println(args[i]);
}
public static void main(String[] args) {
   print("3","a","b","c");
}
```

## 枚举类

```java
enum Size {
    SMALL("s"),MEDIUM("m"),Large("l"),EXTRA_LARGE("xl");
    //枚举类的构造函数
    private Size(String abbreviation){this.abbreviation=abbreviation;}
    private String abbreviation;
    public String getAbbreviation(){return abbreviation;}
}
//枚举类的测试类
public static void main(String[] args) {
    Size size=Enum.valueOf(Size.class,"MEDIUM");
    //or instance like this
    Size size2=Size.MEDIUM;
    System.out.println("abbreviation= "+size.getAbbreviation());
}
```

## 泛型

`ArrayList<Employee> staff=new ArrayList<>();`, 在Java7中可以省略后面的类型参数。称为"菱形"语法。

## Java8新增内容

* LocalDate类
* 





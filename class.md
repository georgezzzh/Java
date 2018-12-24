## 类的使用
>一个.java文件只能有一个public类

类的声明与使用  

    class Person{
      String name;
      int age;
      public void speak(){
    System.out.println("姓名"+name+" 年龄 "+age);
    }
    }
    public class Main {

      public static void main(String[]args){
    Person per=new Person();
    per.name="george";
    //传递引用就是将一个堆内存空间的使用权交给多个栈内存空间，
    // 每一个栈内存空间都可以修改堆内存空间的内容，并使其内容保存下来。
    Person per2=per;
    per.age=18;
    per2.age=20;
    per.speak();//age=20
    }
    }
### 类的权限
权限依次从大到小是: *public>protected>default>private*
> public，在类的内部，被他修饰的无论是属性还是方法，都可以在任何地方访问的到  
protectded ,可以被同一个包其他类访问，也可以被不同包的子类访问。  
default(只能被同一个包中的访问)，称为包访问权限。    
private，被声明为private的成员只能被此类中的其他成员访问，不能被类外看到。  
### 构造函数
一般情况权限为*public*  
1. 构造方法可以重载。   
2. 匿名对象就是没有明确给出名字的对象，匿名对象是开辟了堆内存空间并可以直接使用的对象。  
3. 匿名对象只使用一次，只在堆内存开辟空间，不存在栈中引用。
4. 匿名对象在使用一次之后就等待被垃圾收集机制回收。   

       class Person{
       private String name;
       private int age;
       //构造函数
       public Person(String n,int a){
        name=n;
        age=a;
       }
        public void speak(){
        System.out.println("姓名: "+name+" 年龄:"+age);
         }
        }
        public class Main {

        public static void main(String[]args){
        //匿名对象
        new Person("george",20).speak();
        }
        }


### this
含义：this代表对象自身的引用  
作用：(1) 解决变量名冲突.  
     (2)解决不确定性的问题.   

    public Person(String name,int age){
        //使用this解决变量名冲突
        this.name=name;
        this.age=age;
    }
>在方法参数或方法中的局部变量和类的属性同名的情况，属性会被屏蔽。因此，要访问属性则需要用**this**属性
#### 使用this调用构造方法
1. 如果一个类中有多个构造方法，可用this(参数)的形式互相调用，以简化代码。  
2. （注意） this(参数) 调用语句只能放在构造方法的首行。     

        //使用this调用构造方法
         class Person{
        private String name;
         private int age;
         public Person(){
          System.out.println("一个新对象被实例化");
          }
          public Person(String name){
             this();
            this.name=name;
         }
         public Person(String name,int age){
            this(name);
             this.age=age;
         }
       public String getInfo(){
        return "姓名"+name+"年龄"+age;
       }
         }
       public class Main {

       public static void main(String[]args){
       Person per=new Person("george",20);
       System.out.println(per.getInfo());
        }
        }
## static关键字
*由static声明的属性，叫静态属性。*  
*由static声明的方法，叫静态方法。*   
**静态属性和静态方法是所有对象共同拥有的，可以由类名称直接调用。**     
#### 1. 静态属性

    class Person{
      static String school="Scu";
    }
    public class Main{
      public static void main(String[]args){
        //修改类的静态属性，不用实例化对象，可以由类名称直接调用
        Person.school="Tsinghua University";
      }
    }

#### 2. 静态方法

    class Person{
    private String name;
    private int age;
    static String school="scu";
    //静态方法
    public static void setSchool(String s){
        school=s;
    }
    public Person(){
    System.out.println("一个新对象被实例化");
    }
    public Person(String name){
        this();
        this.name=name;
    }
    public Person(String name,int age){
        this(name);
        this.age=age;
    }
    public void getInfo(){
        System.out.println("name "+this.name+" age: "+this.age+" "+this.school);
    }
    }

    public class Main {
    public static void main(String[]args){
        Person.setSchool("Tsinghua University");
       Person per=new Person("george",20);
       per.getInfo();
    }
    }

使用static声明的方法又叫*类方法*,可由类名称直接调用。  
>1. 任何方法都可以使用静态属性和调用静态方法。
>2. 静态方法不能使用非静态属性和调用非静态方法。

静态属性存储在: data segment  
非静态属性存储在: 内存的堆中
### **特殊的静态方法---mian()**   
> public——权限修饰符：权限最大。保证任何位置都可以访问该函数，不受任何限制。  
static——静态修饰符：无需实例化，可以直接由类名称调用。  
void——返回值为空：main()是程序的起点，无返回值。  
main——函数名：系统规定好的方法名。  
String[] args——命令行参数：类在执行时传入的参数。  

Java中构造函数没有默认参数，只能通过重载来实现。

# instanceof
## 作用: 判断一个对象到底是哪个类的实例
### 返回一个bolean类型的值
引用类型之间的转换只能在具有继承关系的两个类型之间。如果两个没有任何继承关系的类型，则无法进行转换。   
如果试图将一个父类转换为子类，则这个对象必须(编译时为父类，运行时为子类)，否则运行时引发异常。  

       //instanceof使用方法
       Fruit f2=new Fruit("none");
       System.out.println(f2 instanceof Apple);

>重写toString()方法  
>重写equals()方法  
>Java中任何一个类都继承了Object类以内的方法。任何一个子类均可以直接使用这些方法。   

## Object对象具有的方法
        //构造方法
        public Object()
        //打印对象时调用
        public String toString()
        //对象比较
        public boolean equals(Object obj);   

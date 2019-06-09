## 代理 (proxy)

利用代理可以在运行时创建一个实现了一组给定接口的新类，这种功能只有在编译时无法确定需要实现哪个接口时才有必要使用。

*TraceHander.java*

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler implements InvocationHandler {
    private Object target;
    public TraceHandler(Object t){target=t;}
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("."+ method.getName()+"(");
        if(args!=null)
            for(int i=0;i<args.length;i++)
                System.out.print(args[i]);
        System.out.println(")");
        return method.invoke(target,args);
    }
}
```

*start.java*

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class Start{
    public static void main(String[]args){
        Object[]elements=new Object[1000];
        for(int i=0;i<elements.length;i++)
        {
            int value=i+1;
            InvocationHandler handler=new TraceHandler(value);
            //代理了Comparable接口中的compareTo方法
            //代理对象属于在运行时定义的类,有一个名字如$proxy0
            //它的compareTo方法调用了代理对象处理器的invoke方法
            Object proxy=Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
            elements[i]=proxy;
        }
        int key=new Random().nextInt(elements.length)+1;
        //数组中填充了代理对象，所以compareTo调用了TraceHander类中的invoke方法
        int result= Arrays.binarySearch(elements,key);
        if(result>=0) System.out.print(elements[result]);
    }
}
```

### 代理类的特性

代理类是程序运行过程中创建的，一旦被创建，就变成了常规类，与虚拟机中任何其他类没有什么区别。

一个代理类只有一个实例域(调用处理器), 为了履行代理对象的职责，所需要的任何附加数据都必须存储在调用处理器中。例如示例程序中，TraceHandler包括了实际的对象。

### InvocationHander API

`Object invoke(Object proxy,Method method,Object[]args)`

定义了代理对象调用方法时希望执行的动作。

### Proxy API

`static Object newProxyInstance(ClassLoader loader,Class<?>[]interfaces,InvocationHander hander)`  

构造方法指定接口的代理类的一个新实例，所有方法会调用给定处理器对象的invoke方法




package reflect;

import java.lang.reflect.Field;
/**
 * 使用反射进行改变对象的值
* */
public class ReflectOnRuntime {
    public void accessEmployeeObject()
    {
        Employee harry=new Employee("Harray Hacker",25000,10,1,1999);
        Class c1=harry.getClass();
        Field f= null;
        try {
            //反射机制默认行为首先于Java的访问控制，如果一个Java程序没有收到安全管理器的控制，就可以覆盖访问控制
            f = c1.getDeclaredField("name");
            //开启访问权限，调用Field,Method,Constructor对象的setAccessible()方法
            f.setAccessible(true);
            Object v = f.get(harry);
            //设置私有属性
            f.set(harry,"Harray Peter");
            System.out.println(v);
            System.out.println(harry.getName());
        } catch (NoSuchFieldException|IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

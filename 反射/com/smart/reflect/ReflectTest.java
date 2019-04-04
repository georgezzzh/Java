package com.smart.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable{
        //类加载器
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        Class clazz=loader.loadClass("com.smart.reflect.Car");
        //获取默认构造方法
        Constructor constructor=clazz.getConstructor((Class[])null);
        Car car=(Car)constructor.newInstance();
        //通过反射
        Method setBrand=clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"红旗");
        return car;
    }
    public static void main(String[]args) throws Throwable{
        Car car=initByDefaultConst();
        System.out.println(car.toString());
    }
}

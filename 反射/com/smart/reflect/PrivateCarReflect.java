package com.smart.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateCarReflect{
    public static void main(String[]args)throws Throwable{
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        Class clazz=loader.loadClass("com.smart.reflect.PrivateCar");
        PrivateCar privateCar=(PrivateCar) clazz.getDeclaredConstructor().newInstance();
        Field colorFld=clazz.getDeclaredField("color");
        //设置属性
        colorFld.setAccessible(true);
        colorFld.set(privateCar,"red");
        //调用方法
        Method driveMethod=clazz.getDeclaredMethod("drive");
        driveMethod.setAccessible(true);
        driveMethod.invoke(privateCar,(Object[])null);
    }
}

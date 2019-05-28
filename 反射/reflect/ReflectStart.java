package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/**
 *使用Reflect遍历所有的方法和属性
 *
 * 传入类
 * 打印所有公共方法
 * 打印所有方法，仅该类的，不包括父类
 * getModifier,获取方法的描述符，例如public或者static等
 * getParameterType, 返回参数类型
 * getReturnType, 获取返回值参数
 */
public class ReflectStart {
    public static void printMethod(Class c)
    {
        Method[] methods = c.getMethods();
        System.out.println("==============\nall public methods and super class methods\n");
        for(Method method:methods)
            System.out.println(method);
        Method[] declaredMethods = c.getDeclaredMethods();
        System.out.println("==============\nall methods\n");
        for(Method method:declaredMethods){
            System.out.println(method);
            Class<?> returnType = method.getReturnType();
            System.out.println("return type:\t"+returnType.getName());
            String modifiers= Modifier.toString(method.getModifiers());
            System.out.println("modifiers:\t"+modifiers);
            Class<?>[] parameterTypes = method.getParameterTypes();
            for(int j=0;j<parameterTypes.length;j++)
                System.out.println("parameter:\t"+parameterTypes[j].getName());
        }

    }
    /**
     * 打印所有的域
     * getFields,包括public域
     * getDeclareFields, 所有的域
     */
    public static void printField(Class c)
    {
        Field[] fields = c.getFields();
        System.out.println("====================\nString Public Fields\n");
        for(Field field:fields)
            System.out.println(field);
        Field[] declaredFields = c.getDeclaredFields();
        System.out.println("====================\nString all methods\n");
        for(Field field:declaredFields)
            System.out.println(field);
    }

}

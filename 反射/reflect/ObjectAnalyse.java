package reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/**
 * 利用反射动态的返回toString()
 * 返回所有共有的属性
 */
public class ObjectAnalyse {
    private ArrayList<Object> visited=new ArrayList<>();
    public String toString(Object object)
    {
        if(object==null) return "null";
        visited.add(object);
        Class c1=object.getClass();
        if(c1.equals(String.class)){
            return (String)object;
        }
        if(c1.isArray()){
            //数组中元素的类型
            String r=c1.getComponentType()+"[]{";
            for(int i=0;i< Array.getLength(object);i++){
                if(i>0) r += ",";
                Object val=Array.get(object,i);
                if(c1.getComponentType().isPrimitive()) r+=val;
                else
                    r+=toString(val);
            }
            return r+"}";
        }
        String r=c1.getName();
        while (c1!=null){
            Field[]fields=c1.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);
            for(Field field:fields){
                //只保存非static属性
                if(!Modifier.isStatic(field.getModifiers())){
                    r+="[";
                    r+= field.getName()+"=";
                    Class t=field.getType();
                    Object val= null;
                    try {
                        val = field.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if(t.isPrimitive()) r+=val+"]";
                    else r+=toString(val);
                }
            }
            c1=c1.getSuperclass();
        }
        return r;
    }
    public static void main()
    {
        ArrayList<Integer>  squares=new ArrayList<>();
        for(int i=0;i<5;i++)
            squares.add(i*i);
        ObjectAnalyse analyse=new ObjectAnalyse();
        int[]arr=new int[]{1,2,3};
        System.out.println(analyse.toString(squares));
    }
}

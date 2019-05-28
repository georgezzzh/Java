package reflect;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
* 利用反射中的Array，进行数组的复制
* */
public class CopyOfTest {
    public static Object goodCopyOf(Object a,int newLength)
    {
        Class c1=a.getClass();
        if(!c1.isArray()) return null;
        Class componentType = c1.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a,0,newArray,0,Math.min(newLength,length));
        return newArray;
    }
    public static void main()
    {
        int[]a={1,2,3};
        a=(int[])goodCopyOf(a,5);
        System.out.println(Arrays.toString(a)+"\t"+a.length);
    }
}

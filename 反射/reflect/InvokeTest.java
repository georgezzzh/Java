package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/**
 *使用Method类中的Invoke方法进行动态调用方法
 */

public class InvokeTest {
    public static double square(double x)
    {
        return x*x;
    }
    public double sqrt(double x)
    {
        return Math.sqrt(x);
    }
    public InvokeTest(){}
    public static void main() throws Exception
    {
        Method square= null;
        square = InvokeTest.class.getMethod("square", double.class);
        //调用静态方法,obj参数写null即好
        double t=(double)square.invoke(null,11);
        System.out.println(t);

        Constructor constructor=InvokeTest.class.getConstructor();
        Object obj = constructor.newInstance();
        Method sqrt=InvokeTest.class.getMethod("sqrt", double.class);
        //非静态方法，需要指明对象
        double sq=(double)sqrt.invoke(obj,11);
        System.out.println("sqrt is:"+sq);
    }
}

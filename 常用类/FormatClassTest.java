import java.text.DecimalFormat;

public class FormatClassTest {
    public static void main(String[]args){
        DecimalFormat df1,df2;
        df1=new DecimalFormat("#.00");
        df2=new DecimalFormat("0.00");
        System.out.println(df1.format(0.1));
        System.out.println(df2.format(0.1));
        //每四位做一下分割,保留三位小数
        DecimalFormat df3=new DecimalFormat("#,####.000");
        System.out.println(df3.format(8882100.112));
    }
}

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class CalendarClassDemo {
    public static void main(String[]args){
        //Date类基本被废弃，除了getTime()
        Date now=new Date();
        System.out.println(now.getTime());
        GregorianCalendar cal=new GregorianCalendar();
        //get(Field)，返回时间中每个属性的值，月份时0-11
        //输入时间的具体详情,年+月+日+时+分+秒
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH)+1);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
        //返回一个日期，感觉这个函数没啥卵用
        System.out.println(cal.getTime());
        //返回1970.1.1以来的毫秒数
        System.out.println(cal.getTimeInMillis());
        //设置时间的值，getTimeInMillis()出现负数
        cal.set(Calendar.YEAR,1969);
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.getTimeInMillis());
        System.out.println(cal.getTime());
        //根据制定的字段增加/减少时间
        cal.add(Calendar.MONTH,12);
        System.out.println(cal.getTime());
        //根据指定的字段增加/减少，不影响上一级
        cal.roll(Calendar.MONTH,12);
        System.out.println(cal.getTime());
    }
}

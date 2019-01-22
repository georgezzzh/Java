import java.time.LocalDate;
import java.time.ZoneId;

public class LocalDateClass {
    public static void main(String[]args){
        //当前日期
        //time包是线程安全的类
        LocalDate today=LocalDate.now();
        System.out.println("Current Date: "+today);
        System.out.println(today.getYear());
        //这下月份终于从1月算了
        LocalDate firstDay_2014=LocalDate.of(2014,1,1);
        System.out.println("specific Date= "+firstDay_2014);
        //设定时区
        LocalDate todayBeijing=LocalDate.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(todayBeijing);
        //用1970年的时间计算
        LocalDate dateFromBase=LocalDate.ofEpochDay(365);
        System.out.println(dateFromBase);
        //2014年的第100天
        LocalDate hundredDay2014=LocalDate.ofYearDay(2014,100);
        System.out.println(hundredDay2014);
        System.out.println("*****************分隔符*******************");
        LocalTimeTest.main();
    }
}

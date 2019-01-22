import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimeTest {
    public static void main(){
        //当前时间 时分秒 纳秒
        LocalTime now= LocalTime.now();
        System.out.println(now);
        //根据时分秒设定一天
        LocalTime specificTime=LocalTime.of(12,0,0);
        System.out.println(specificTime);
        //根据时区设定
        LocalTime timeSH=LocalTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("Current time in sh: "+timeSH);
        //一天当中的第几秒
        LocalTime specificSecondTime=LocalTime.ofSecondOfDay(10000);
        System.out.println(specificSecondTime);
        System.out.println("*****************分隔符***************");
        Instant timestamp=Instant.now();
        System.out.println(timestamp);
    }
}

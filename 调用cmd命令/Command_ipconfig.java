import java.io.*;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command_ipconfig {
    public static void main(String[]args) throws IOException {
        Process p1=Runtime.getRuntime().exec("cmd.exe /c ipconfig");
        InputStream is=p1.getInputStream();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is, Charset.forName("GBK")));
        String line=null;
        String result="";
        while ((line=bufferedReader.readLine())!=null){
            result+=line;
            System.out.println(line);
        }
        String ipAddr="";
        //正则模式,\\s表示空格，匹配空格或者点任意多次，匹配:和空格一次，匹配点或数字任意次，最后一组就是Ip地址
        Pattern pattern=Pattern.compile("IPv4 地址[\\s,\\.]*:\\s([\\d,\\.]*)");
        //匹配目标字符串
        Matcher matcher=pattern.matcher(result);
        if(matcher.find()){
            System.out.println("发现了");
            //匹配结果
            ipAddr=matcher.group(1);
        }
        System.out.println("IP地址为:"+ipAddr);
    }
}

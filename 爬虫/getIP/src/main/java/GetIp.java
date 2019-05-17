import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetIp {
    public static String getIpInfo(String ip)
    {
        String url="https://tool.lu/ip/ajax.html";
        Connection connection= Jsoup.connect(url);
        Map<String,String>data=new HashMap<>();
        data.put("ip",ip);
        Connection.Response resp= null;
        try {
            resp = connection.ignoreContentType(true).data(data).method(Connection.Method.POST).execute();
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"message\":\"error\"}";
        }
        String info=resp.body();
        JsonElement jsonObject=new JsonParser().parse(info);
        JsonElement position=jsonObject.getAsJsonObject().get("text");
        return position.toString();
    }
    public static void main(String[]args){
        String info=getIpInfo("223.129.13.45");
        System.out.println(info);
    }
}

import com.google.gson.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Map;
/**
 * 访问成绩接口
 */

class QueryGrade {

    static void get(Map<String,String>cookies) throws IOException{
        String url="http://zhjw.scu.edu.cn/student/integratedQuery/scoreQuery/schemeScores/callback";
        Connection conn= Jsoup.connect(url);
        cookies.put("selectionBar","1443373");
        conn.cookies(cookies);
        Connection.Response resp=conn.ignoreContentType(true).method(Connection.Method.GET).execute();
        System.out.println("请求结果："+resp.body());
        String str=resp.body();
        JsonElement je=new JsonParser().parse(str);
        JsonArray ja=je.getAsJsonArray().get(0).getAsJsonObject().get("cjList").getAsJsonArray();

    }
}

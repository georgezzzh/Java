import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String string2hex(String s){
        int len=s.length();
        char[] chars = s.toCharArray();
        StringBuffer str=new StringBuffer(len*2);
        for(int i=0;i<len;i++){
            int ascii = Character.codePointAt(chars, i);
            str.append(Integer.toHexString(ascii));
        }
        return str.toString();
    }
    private static Map<String,String> makeCookie(String url)
    {
        String hexString=string2hex(url);
        Map<String,String> cookie=new HashMap<>();
        //return "srcurl="+hexString+";"+"path=/";

        cookie.put("srcurl",hexString);
        cookie.put("path","/");
        return cookie;

    }
    public static Document send(String url)
    {

        Document document=null;
        try {
            //第一次访问
            Connection.Response resp1 = Jsoup.connect(url).ignoreContentType(true).execute();
            String html=resp1.body();
            Pattern pattern=Pattern.compile("self\\.location\\s*=\\s*\"(.*?)\"");
            Matcher matcher=pattern.matcher(html);
            if(!matcher.find()){
                throw new IOException("First request response not contain useful info");
            }
            //设置第二次请求参数
            //伪造cookie,该网站用浏览器端js生成的cookie，这里改写
            String para2 = matcher.group(1)+string2hex("1920,1080");
            String url2="https://e.glgoo.top/"+para2;
            Map<String,String> manualCookie = makeCookie(url);
            //第二次访问
            Connection connect = Jsoup.connect(url2).cookies(manualCookie).cookies(resp1.cookies()).ignoreContentType(true);
            Connection.Response resp = connect.execute();
            String body = resp.body();
            Map<String, String> cookies2 = resp.cookies();
            //System.out.println("manual cookie:\n"+manualCookie);
            //System.out.println("第二次返回的cookie:\n"+cookies2);
            Pattern pattern2=Pattern.compile("self\\.location\\s*=\\s*\"(.*?)\"");
            Matcher matcher2 = pattern2.matcher(body);
            if(!matcher2.find())
                throw new IOException("response2  return useless info");
            //进行第三次访问
            String url3 = matcher2.group(1);
            document = Jsoup.connect(url3).cookies(manualCookie).cookies(cookies2)
                    .ignoreContentType(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static void main(String[]args){
        Document html = send("https://e.glgoo.top/scholar?cites=12452666453585360586&start=0");
        if(html==null){
            System.out.println("抓取出错");
            return;
        }
        //System.out.println(html);
        //#gs_res_ccl_mid
        Elements title = html.select("#gs_res_ccl_mid > div > div.gs_ri > h3 a");
        //#gs_res_ccl_mid > div:nth-child(1) > div.gs_ri > div.gs_a
        Elements authors=html.select("#gs_res_ccl_mid > div > div.gs_ri > div.gs_a");
        //#gs_res_ccl_mid > div:nth-child(1)
        //#gs_res_ccl_mid > div:nth-child(1) > div.gs_ri > h3
        System.out.println(authors.toString());
        System.out.println(title.toString());
    }
}

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.httpclient.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class PostJsopu {
    public static String captcha(){
        Scanner in=new Scanner(System.in);
        String tmp=in.nextLine();
        return tmp;
    }
    public static void printGrade(String file) throws IOException{

        JsonParser parser=new JsonParser();
        //JsonObject object=(JsonObject)parser.parse(new FileReader("C:\\Users\\geoge\\Desktop\\json.txt"));
        JsonObject object=(JsonObject)parser.parse(file);
        JsonArray array=object.get("list").getAsJsonObject().get("records").getAsJsonArray();
        for(JsonElement arr:array)
            System.out.println(arr);
    }
    public static void queryGrade(String url,Map<String,String>cookies) throws IOException{
        Connection conn=Jsoup.connect(url);
        cookies.put("selectionBar","125803405");
        conn.cookies(cookies);
        conn.header("Referer","http://zhjw.scu.edu.cn/student/integratedQuery/scoreQuery/allPassingScores/index");
        conn.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        conn.header("Connection","keep-alive");
        conn.header("X-Requested-With","XMLHttpRequest");
        conn.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        //设置请求表单
        Map<String,String> formdata=new HashMap<>();
        formdata.put("zxjxjhh","2018-2019-1-1");
        formdata.put("kch","");
        formdata.put("kcm","");
        formdata.put("pageNum","1");
        formdata.put("pageSize","30");
        Connection.Response resp=conn.ignoreContentType(true).method(Connection.Method.POST).data(formdata).execute();
        //System.out.println(resp.body());
        printGrade(resp.body());
    }
    public static void login() throws IOException {

        HttpClient httpClient = new HttpClient();
        GetMethod getMethod1 = new GetMethod("http://zhjw.scu.edu.cn/img/captcha.jpg");
        getMethod1.setRequestHeader("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        getMethod1.setRequestHeader("Referer", "http://zhjw.scu.edu.cn/login");
        getMethod1.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        //保存下载下来的验证码
        StringBuffer tmpcookies1 = new StringBuffer();
            httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
            httpClient.executeMethod(getMethod1);
            Cookie[] cookies1 = httpClient.getState().getCookies();
            Map<String,String>cookieMap=new HashMap<>();
            for (Cookie c1 : cookies1) {
                tmpcookies1.append(c1.toString() + ";");
                System.out.println("登录页面的cookies： " + c1.toString());
                String[]ctemp=c1.toString().split("=");
                cookieMap.put(ctemp[0],ctemp[1]);
            }

            FileOutputStream fs = new FileOutputStream(new File("C:\\Users\\geoge\\Desktop\\img.png"));
            InputStream is = getMethod1.getResponseBodyAsStream();
            byte[] b = new byte[1024];
            int n = -1;
            while ((n = is.read(b)) != -1) {
                fs.write(b, 0, n);
            }
            is.close();
            fs.close();

        //进行登陆页面
        System.out.println("请输入验证码");
        Map<String,String> datas=new HashMap<>();

        datas.put("j_username","2016141411122");
        datas.put("j_password","211915");
        String captchaStr=captcha();
        datas.put("j_captcha",captchaStr);
        System.out.println("验证码:"+captchaStr);
        //我竟然没看把表单提交到哪里去了，tmd...爬了半天的www.zhjw.scu.edu.cn
        Connection con2= Jsoup.connect("http://zhjw.scu.edu.cn/j_spring_security_check");
        con2.header("Referer", "http://zhjw.scu.edu.cn/login");
        con2.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        con2.header("Accept-Encoding","gzip, deflate");
        con2.header("Accept-Language","zh-CN,zh;q=0.9");
        con2.header("Connection","keep-alive");
        con2.header("Content-Length","57");
        con2.header("Content-Type","application/x-www-form-urlencoded");
        con2.header("Host","zhjw.scu.edu.cn");
        con2.header("Origin","http://zhjw.scu.edu.cn");
        con2.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        System.out.println("form datas:"+datas);
        Connection.Response resp=con2.ignoreContentType(true).method(Connection.Method.POST).data(datas).cookies(cookieMap).execute();
        System.out.println("loginBeforeCookie: "+cookieMap);
        //
        Map<String,String> logincookie=resp.cookies();
        System.out.println("loginCookie: "+logincookie);

        //System.out.println(resp.body());
        String gradeUrl="http://zhjw.scu.edu.cn/student/integratedQuery/scoreQuery/allTermScores/data";
        queryGrade(gradeUrl,cookieMap);
    }

    public static void main(String[]args){

        try{
            login();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

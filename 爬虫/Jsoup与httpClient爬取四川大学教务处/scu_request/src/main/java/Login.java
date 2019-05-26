import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Login {
    private static String captcha(){
        Scanner in=new Scanner(System.in);
        return in.nextLine();
    }
    /**
    *@return 发送回验证码的cookie
    * */
    private static Map<String,String> saveCaptcha() throws IOException
    {
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod1 = new GetMethod("http://zhjw.scu.edu.cn/img/captcha.jpg");
        //保存下载下来的验证码
        httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        httpClient.executeMethod(getMethod1);
        Cookie[] cookies1 = httpClient.getState().getCookies();
        Map<String,String>cookieMap=new HashMap<>();
        for (Cookie c : cookies1) {
            String[]temp=c.toString().split("=");
            cookieMap.put(temp[0],temp[1]);
        }
        FileOutputStream fs = new FileOutputStream(new File("C:\\Users\\geoge\\Desktop\\img.png"));
        InputStream is = getMethod1.getResponseBodyAsStream();
        byte[] b = new byte[1024];
        int n ;
        while ((n = is.read(b)) != -1) {
            fs.write(b, 0, n);
        }
        is.close();
        fs.close();
        return cookieMap;
    }
    /**
     * 登录
     * @return 返回登录成功的cookie
     */
    static Map<String,String> login() throws IOException {
        Map<String,String> cookieMap=saveCaptcha();
        //进行登陆页面
        System.out.println("请输入验证码");
        Map<String,String> formdata=new HashMap<>();
        formdata.put("j_username","2016141411122");
        formdata.put("j_password","211915");
        String captchaStr=captcha();
        formdata.put("j_captcha",captchaStr);

        Connection con= Jsoup.connect("http://zhjw.scu.edu.cn/j_spring_security_check");
        Connection.Response resp=con.ignoreContentType(true).method(Connection.Method.POST).
                data(formdata).cookies(cookieMap).execute();
        System.out.println("loginBeforeCookie: "+cookieMap);
        return cookieMap;
    }
}

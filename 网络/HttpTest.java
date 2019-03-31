import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpTest {
    public static void sendRequest(){
        String result="";
        try{
            String url="http://localhost:8080/sp31_war_exploded/wechat";
            URL readURL=new URL(url);
            HttpURLConnection connection=(HttpURLConnection)readURL.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.connect();
            //写入参数
            DataOutputStream ds=new DataOutputStream(connection.getOutputStream());
            String param="code=12345";
            ds.writeBytes(param);
            ds.flush();
            ds.close();
            //读取返回的数据
            BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line=null;
            while((line=in.readLine())!=null){
                result+=line;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println(result);
        }
    }
    public static void main(String[]args){
        sendRequest();
    }
}

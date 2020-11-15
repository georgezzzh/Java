import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ReadConfig {
    public static Map readFile(){
        Map map=new HashMap();
        try{
            String fileUrl=ReadConfig.class.getResource("/").getPath()+"mail.json";
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(fileUrl)));
            StringBuffer fileContent=new StringBuffer();
            String temp=null;
            while ((temp=br.readLine())!=null)
                fileContent.append(temp);
            JsonObject jsonObject=(JsonObject) new JsonParser().parse(fileContent.toString());
            String user=jsonObject.get("user").getAsString();
            String from=jsonObject.get("from").getAsString();
            String to=jsonObject.get("to").getAsString();
            String password=jsonObject.get("password").getAsString();
            map.put("user",user);
            map.put("from",from);
            map.put("to",to);
            map.put("password",password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
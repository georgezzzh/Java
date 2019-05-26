import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[]args){

        try{
            Map<String,String> cookieMap= Login.login();
            System.out.println("login after cookie:"+cookieMap);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

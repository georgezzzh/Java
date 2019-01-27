import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[]args){
        File from=new File("C:\\Users\\George\\IdeaProjects\\MyProject\\out\\production\\MyProject\\com\\example\\web\\PageTest.class");
        System.out.println(from);
        File to=new File("C:\\Users\\George\\Downloads\\apache-tomcat-9.0.14\\webapps\\mypage\\WEB-INF\\classes\\com\\example\\web\\PageTest.class");

        try(FileInputStream fi=new FileInputStream(from);
            FileOutputStream fo=new FileOutputStream(to)){
            byte[]temp=new byte[1024];
            int num=-1;
            //如果为空返回-1
            while ((num=fi.read(temp))!=-1){
                //这个write方法，读取数组，开始位置，读取的长度
                fo.write(temp,0,num);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void copyFile(String source,String target) throw IOException{
        File source=new File(source);
        File target=new File(target);
        FileInputStream fi=new FileInputStream(source);
        FileOutputStream fo=new FileOutputStream(target));
        byte[] bytes=new byte[1024];
        int len=-1;
        //read方法下一次读取，文件的当前位置会自动移动; 如果为空返回-1
        while ((len=fi.read(bytes))!=-1){
                //write方法，读取数组，数组的开始位置，读取的长度
                fo.write(bytes,0,len);
        }
    }
    public static void main(String[]args){
        try{
            copyFile(args[1], args[2]);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

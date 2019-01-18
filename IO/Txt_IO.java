import java.io.FileWriter;
public class Txt_IO {
    public static void main(){
        //使用字符串不同于序列化输出，使用字符串类似其他语言的简单输入输出
        try{
            FileWriter writer=new FileWriter("foo.txt");
            writer.write("Always hello world");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

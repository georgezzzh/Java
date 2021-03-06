import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

/*
* 在IDEA读取文件时，文件放在与src同一个目录中，否则会出现路径出错
* */
public class Collection {
    HashSet<Song> songList=new HashSet<Song>();

    public static void main(String[]args){
        new Collection().go();
    }
    public void go(){
        getSong();
        System.out.println(songList);
    }
    //读取txt文件的
    void getSong(){
        try{
            //放在Src找不到。。。需要放在src外一层
            BufferedReader reader=new BufferedReader(new FileReader("songList.txt"));
            String line=null;
            while((line=reader.readLine())!=null){
                addSong(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //把读取到的完整信息存储到ArrayList中
    void addSong(String line){
        String[]token=line.split(",");
        Song nextSong=new Song(token[0],token[1],token[2],token[3]);
        songList.add(nextSong);

    }
}

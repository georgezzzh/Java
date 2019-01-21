import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
* 在IDEA读取文件时，文件放在与src同一个目录中，否则会出现路径出错
* */
public class Collection{
    ArrayList<Song> songList=new ArrayList<Song>();
    //踩得一个坑是，字符串排序时，按照首字母排序，应该是按照的ASCII码来排序的
    //以为小写字母排后面了，震惊了，后来才发现小写字母比大写字母排的要后
    class ArtistSort implements Comparator<Song>{
        public int compare(Song one,Song two){
            return one.getArtist().compareTo(two.getArtist());
        }
    }
    public static void main(String[]args){
        new Collection().go();
    }
    public void go(){
        getSong();
        //Collections中的排序方法,排序对象时，需要自己改
        Collections.sort(songList,new ArtistSort());
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

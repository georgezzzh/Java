/*
* 用Jsoup爬取豆瓣250，好像很多人学爬虫都喜欢爬取豆瓣网站....
* */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MyJsoup {
    public static String spider(String url){
        StringBuffer result=new StringBuffer("");
        try{
            Document document= Jsoup.connect(url).get();
            Elements elements=document.select(".title:first-child");
            for(Element ele:elements){
                result.append(ele.text());
                result.append(",");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
    public static void main(String[]args){
        String[]urls=new String[10];
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(new File("C:\\Users\\geoge\\Desktop\\douban.txt")))){

            for(int i=0;i<10;i++){
                //豆瓣分页显示电影
                String urlTmp="https://movie.douban.com/top250?start="+i*25+"&filter=";
                String res=spider(urlTmp);
                String[]temp=res.split(",");
                for(String t:temp){
                    writer.append(t);
                    //换行
                    writer.newLine();
                }

            }
        }catch (Exception e){
            System.out.println("IO出错");
            e.printStackTrace();
        }
    }
}

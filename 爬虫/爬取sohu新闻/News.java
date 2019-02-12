import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class News {
    //获取头条消息
    public static HashMap<String, String> getTopNews() throws IOException {
        HashMap<String,String> res=new HashMap<>();
        Document document= Jsoup.connect("http://www.sohu.com").get();
        Elements news=document.select(".focus-news-box .list16 ul li a");
        System.out.println(news.size());
        for(Element ele:news){
            String title=ele.attr("title");
            String url=ele.attr("href");
            res.put(title,url);
        }
        return res;
    }
    //根据新闻的URL，获取新闻的文本内容并返回
    public static String getNewsContent(String url){
        StringBuffer content=new StringBuffer();
        try{
            Document document=Jsoup.connect(url).get();
            Elements elements=document.select(".article p");
            for(Element tmp:elements)
                content.append(tmp.text()+"\n");

        }catch (Exception e){
            e.printStackTrace();
        }
        return content.toString();
    }
    //获取IT消息，返回hashMap
    public static HashMap getITnews(){
        HashMap<String ,String>content=new HashMap<>();
        try{
            Document document=Jsoup.connect("http://it.sohu.com/?spm=smpc.home.top-nav.22.15499750201880kbq2U0").get();
            Elements topNews=document.select(".z-main1_mid_head-line .z-head-line h1 a");
            Elements smallerNews=document.select(".z-main1_mid_head-line .z-head-line p a");
            for(Element tmp:topNews)
                content.put(tmp.text(),tmp.attr("href"));
            for(Element tmp:smallerNews)
                content.put(tmp.text(),tmp.attr("href"));


            //科技要闻模块
            Elements techNews=document.select(".z-head-news li a");
            for(Element tmp:techNews)
                content.put(tmp.text(),tmp.attr("href"));
            //前沿___产品模块
            Elements productNews=document.select(".z-c-block-list-item a");
            for(Element tmp:productNews)
                content.put(tmp.text(),tmp.attr("href"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            for(Map.Entry<String,String> tmp:content.entrySet())
                System.out.println(tmp.getKey()+"\t"+tmp.getValue());
        }
        return content;
    }
    public static void main(String[]args){

        /*
        HashMap<String,String>topNews=null;
        try{
            topNews=getTopNews();
        }catch (Exception e){
            e.printStackTrace();
        }
        for(Map.Entry<String,String> it:topNews.entrySet()){
            System.out.println(it.getKey()+"\t"+it.getValue());
            System.out.println(getNewsContent(it.getValue()));
        }
        */
        getITnews();
    }
}

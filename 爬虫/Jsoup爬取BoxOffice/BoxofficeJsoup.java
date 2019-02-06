/*
* 用Jsoup爬取boxOffice的历史票房纪录
* */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class BoxOfficeJsoup {
    public static void main(String[]args){
        ArrayList<HashMap<String,String>> store=new ArrayList<>();
        try{
            Document document=Jsoup.connect("https://www.boxofficemojo.com/alltime/world/").get();
            Elements elements=document.select("#body table tbody tr td table tbody tr");
            //System.out.println(elements);
            for(Element row:elements){
              String number=row.select("td:first-child").text();
              String title=row.select("td:nth-child(2)").text();
              String studio=row.select("td:nth-child(3)").text();
              String worldWide=row.select("td:nth-child(4)").text();
              String year=row.select("td:last-child").text();
              //System.out.println(number+"\t"+title+"\t"+studio+"\t"+worldWide+"\t"+year);
              HashMap<String,String> temp=new HashMap<>();
              temp.put("number",number);
              temp.put("title",title);
              temp.put("studio",studio);
              temp.put("dollar",worldWide);
              temp.put("year",year);
              store.add(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

            //System.out.printf("\n");
            //System.out.printf("%5s%70s%10s%20s%5s",tmp.get("number"),tmp.get("title"),tmp.get("studio"),tmp.get("dollar"),tmp.get("year"));
            try(BufferedWriter writer=new BufferedWriter(new FileWriter(new File("C:\\Users\\geoge\\Desktop\\boxoffice.txt")))){
                for(HashMap<String,String>tmp:store){
                writer.append(tmp.get("number")+","+tmp.get("title")+","+tmp.get("studio")+","+tmp.get("dollar")+","+tmp.get("year"));
                writer.newLine();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

    }
}

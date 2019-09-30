import domain.Paper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    private static Integer string2int(String s)
    {
        if(s.equals(""))
            return 0;
        else
            return Integer.parseInt(s);
    }
    private static String getCitesId(String url)
    {
        Pattern p=Pattern.compile(".*cites=(.*)");
        Matcher matcher=p.matcher(url);
        if(matcher.find())
            return matcher.group(1);
        else
            return "";
    }

    public static List<Paper> getAllPaperByAuthor()
    {
        ArrayList<Paper> papers=new ArrayList<>();
        String req="https://e.glgoo.top/citations?user=kqErKX4AAAAJ&hl=zh-CN&oi=sra&cstart=0&pagesize=80";
        Document doc;
        try {
            doc = Jsoup.connect(req).ignoreContentType(true).post();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't connect "+req);
            return papers;
        }
        Element table = doc.getElementById("gsc_a_b");
        Elements trs = table.select("tr");
        for(Element tr:trs){
            Element title = tr.selectFirst(".gsc_a_t");
            Element year=tr.selectFirst(".gsc_a_y");
            Element citesCount=tr.selectFirst(".gsc_a_c a");
            if(title==null || year==null || citesCount==null)
                break;
            String anchor=citesCount.attr("href");
            String citesId=getCitesId(anchor);
            String authors=tr.selectFirst("td.gsc_a_t > div:nth-child(2)").text();
            String letter=tr.selectFirst("td.gsc_a_t > div:nth-child(3)").text();
            Paper tmp=new Paper(title.text(),string2int(citesCount.text()),
                    Integer.parseInt(year.text()),citesId,authors,letter);
            papers.add(tmp);
        }
        return papers;
    }
    public static List getAllCitesPapers(String citesId)
    {
        List papers=new ArrayList();
        if(citesId==null||citesId.equals(""))
            return papers;
        try {
            for(int start=0;start<10;start+=10){
                String url=Paper.citesPrefix+"cites="+citesId+"&start="+start;
                Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (X11; Linux x86_64) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36").
                        timeout(600).followRedirects(true).get();

                System.out.println("url:"+url+"\ndoc:"+doc);
                Elements cities = doc.select("#gs_res_ccl_mid > div");
                System.out.println("cities:"+cities);
                if(cities.size()==0)
                    break;
                //#gs_res_ccl_mid > div:nth-child(1) > div.gs_ri > h3
                Elements title = cities.select(" div.gs_ri > h3");
                if(title.size()>0)
                    System.out.println("引用的文章是:"+title.text());
                try {
                    //请求稍微慢一些，防止被封IP，代理IP需要付费...
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return papers;
    }
}

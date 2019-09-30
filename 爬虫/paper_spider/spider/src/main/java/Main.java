import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import domain.Paper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[]args) {
        List<Paper> papers=Tools.getAllPaperByAuthor();
        List allCitesPapers = Tools.getAllCitesPapers(papers.get(0).getCitesId());
        //for(Paper p:papers)
        //    System.out.println(p);
        //for(Paper p:papers){
        //    List allCitesPapers = Tools.getAllCitesPapers(p.getCitesId());
        //}
        /*
        Map<String,List> cites=new HashMap<>();
        for(Paper p:papers){
            String citesAnchor = p.getcitesAnchor();
            if(citesAnchor==null||citesAnchor.equals(""))
                continue;

        }
         */
    }
}


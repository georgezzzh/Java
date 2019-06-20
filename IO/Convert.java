import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class Convert {
    public String MDtagToHtml(File file) throws IOException
    {

        StringBuilder converted=new StringBuilder();
        Map<String,String> headTag=new LinkedHashMap<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
        String tmp;
        boolean codeFlag=false;
        int i=0;
        while ((tmp=br.readLine())!=null){
            tmp+="\n";
            //不在代码块中判断, #符号
            if(tmp.startsWith("```") && !codeFlag)
                codeFlag=true;
            else if(tmp.startsWith("```")&& codeFlag)
                codeFlag=false;
            if(tmp.startsWith("###") && !codeFlag){
                String key="id"+i;
                String value=tmp.substring(3).trim();
                String hTag="<h3 id=\""+key+"\">"+value+"</h3>";
                headTag.put(key,value);
                converted.append(hTag);
                //System.out.println(tmp);
                i++;
            }else
                converted.append(tmp);
        }
        br.close();
        StringBuilder atags=new StringBuilder();
        for(Map.Entry entry:headTag.entrySet()){
            String a="* <a href=\"#"+entry.getKey()+"\">"+entry.getValue()+"</a>\n";
            atags.append(a);
        }
        converted.insert(0,atags);
        System.out.println("Insert "+i+" links");
        return converted.toString();
    }

    public static void main(String[]args){
        Convert main=new Convert();
        if(args.length<1){
            System.out.println("please enter convert file name.");
            System.exit(-1);
        }
        if(!args[0].endsWith(".md")){
            System.out.println("error, This program just convert md to html");
            System.exit(-1);
        }

        String path=args[0];
        String duplicate=path.substring(0,path.length()-3)+"_c.md";
        File file=new File(path);
        String converted="";
        try {
            converted=main.MDtagToHtml(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedWriter ow=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(duplicate)),StandardCharsets.UTF_8)))
        {
            ow.write(converted);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

import java.util.HashMap;
public class HashMapTest {
    public static void main(String []args){
        HashMap<String,Integer> scores=new HashMap<String,Integer>();
        scores.put("kathy",42);
        scores.put("Bert",34);
        scores.put("Skyler",70);
        System.out.println(scores);
        System.out.println(scores.get("Bert"));
    }
}
###遍历方法
  HashMap<String,String> files=new HashMap<String,String>();
        files.put("key1","v1");
		files.put("key2","v2");
		files.put("key3","v3");
        //HashMap遍历的方法
        for(Map.Entry<String,String>entry:files.entrySet()){
           System.out.println(entry.getKey()+entry.getValue());
        }
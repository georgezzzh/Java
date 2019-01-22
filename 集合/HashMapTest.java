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

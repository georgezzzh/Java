import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ParseJsonTest {
    public static void JSON_test() throws Exception{
        String file="{\"list\":{\"pageSize\":30,\"pageNum\":1,\"pageContext\":{\"totalCount\":12},\"records\":[[\"2018-2019-1-1\",\"107119000\",\"21\",\"20190111\",\"05\",\"001\",\"01\",\"001\",91,-20,null,\"形势与政策-5\",\"Situation and Policy-5\",0,16,\"必修\",\"考试\",\"A\",null,1],[\"2018-2019-1-1\",\"205013030\",\"02\",\"20190111\",\"05\",\"002\",\"01\",\"001\",95,-20,null,\"操作系统原理\",\"Operating Systems Principles\",3,56,\"选修\",\"考试\",\"A\",null,2],[\"2018-2019-1-1\",\"205019045\",\"03\",\"20190111\",\"05\",\"001\",\"01\",\"001\",82,-22,null,\"电磁场与微波技术\",\"Electromagnetic Field and Microwave Technology\",4.5,76,\"必修\",\"考试\",\"B+\",null,3],[\"2018-2019-1-1\",\"205040030\",\"03\",\"20190111\",\"05\",\"001\",\"01\",\"001\",91,-20,null,\"计算机通信与网络\",\"Computer Communication and Networks\",3,48,\"必修\",\"考试\",\"A\",null,4],[\"2018-2019-1-1\",\"205062030\",\"01\",\"20190111\",\"05\",\"001\",\"01\",\"001\",80,-22,null,\"数字信号处理\",\"Digital Signal Processing\",3,48,\"必修\",\"考试\",\"B+\",null,5],[\"2018-2019-1-1\",\"205070010\",\"01\",\"20190111\",\"05\",\"001\",\"02\",\"001\",89,-21,null,\"通信原理实验\",\"Communication Principle  Experiment\",1,24,\"必修\",\"考查\",\"A-\",null,6],[\"2018-2019-1-1\",\"205078010\",\"05\",\"20190111\",\"05\",\"001\",\"01\",\"001\",90,-20,null,\"微机原理与接口技术实验\",\"Microcomputer Principle and Interface Technology\",1,24,\"必修\",\"考试\",\"A\",null,7],[\"2018-2019-1-1\",\"205085040\",\"01\",\"20190111\",\"05\",\"001\",\"01\",\"001\",86,-21,null,\"现代通信技术\",\"Modern Communication Technology\",4,64,\"必修\",\"考试\",\"A-\",null,8],[\"2018-2019-1-1\",\"205128030\",\"01\",\"20190111\",\"05\",\"001\",\"01\",\"001\",81,-22,null,\"自控原理（全英文）\",\"Principle of Automatic Control\",3,48,\"必修\",\"考试\",\"B+\",null,9],[\"2018-2019-1-1\",\"205130030\",\"02\",\"20190111\",\"05\",\"002\",\"01\",\"001\",87,-21,null,\"物联网技术及应用\",\"The Internet of Things:Technology and Applications\",3,48,\"选修\",\"考试\",\"A-\",null,10],[\"2018-2019-1-1\",\"314056030\",\"02\",\"20190111\",\"05\",\"003\",null,\"001\",93,-20,null,\"计算机组成和体系结构\",\"Computer Organization and Architecture\",3,48,\"任选\",null,\"A\",null,11],[\"2018-2019-1-1\",\"314057040\",\"01\",\"20190111\",\"05\",\"003\",\"01\",\"001\",null,null,\"00\",\"数据结构与算法\",\"Data Structures & Algorithmic\",4,64,\"任选\",\"考试\",null,\"申请缓考\",12]]}}\n";
        JsonParser parser=new JsonParser();
        //JsonObject object=(JsonObject)parser.parse(new FileReader("C:\\Users\\geoge\\Desktop\\json.txt"));
        JsonObject object=(JsonObject)parser.parse(file);
        JsonArray array=object.get("list").getAsJsonObject().get("records").getAsJsonArray();
        for(JsonElement arr:array)
        System.out.println(arr);
    }
    public static void main(String[]args){
        try{
            JSON_test();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

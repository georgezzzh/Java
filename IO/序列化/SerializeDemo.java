import java.io.*;

public class SerializeDemo {

    public static void main(String[]args){
      GameCharacter one=new GameCharacter(50,"glf",new String[]{"bow","sword","dust"});
      GameCharacter two=new GameCharacter(200,"Troll",new String[]{"bare hands","big axe"});
      GameCharacter three=new GameCharacter(120,"magican",new String[]{"spell","invisiblity"});
      //seralize
        try{
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        one=null;
        two=null;
        three=null;
        try{
            ObjectInputStream is=new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter p1=(GameCharacter) is.readObject();
            GameCharacter p2=(GameCharacter) is.readObject();
            GameCharacter p3=(GameCharacter) is.readObject();
            System.out.println(p1.toString());
            System.out.println(p2.toString());
            System.out.println(p3.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

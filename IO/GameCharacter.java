import java.io.Serializable;

public class GameCharacter implements Serializable {
    int power;
    String type;
    String[] weapon;
    public GameCharacter(int p,String t,String[]w){
        this.power=p;
        this.type=t;
        this.weapon=w;
    }
    public  int getPower(){
        return power;
    }
    public String getType(){
        return type;
    }
    public String getWapon(){
        String weaponList="";
        for(String tmp:weapon){
            weaponList+=tmp+"&";
        }
        return weaponList;
    }
    public String toString(){
        String info="info="+Integer.toString(getPower());
        info+=",type="+getType();
        info+=",weapon="+getWapon();
        return info;
    }
}

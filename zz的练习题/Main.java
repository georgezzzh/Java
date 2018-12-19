package com.company;
class Weapon{
    private String name;
    private int strength;
    Weapon(String name){
        switch (name){
            case "original sword":
                this.strength=30;
                break;
            case "War Axe":
                this.strength=50;
                break;
            case "Gold Bow":
                this.strength=30;
                break;
            case "little sword":
                this.strength=10;
                break;
             //设置一个异常
            default:try {
                throw new Exception("weapon not exist");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public int attack(){
        return this.strength;
    }
    public String toString(){
        return this.name+" "+this.strength;
    }
    public void changeWeapon(String name){
        switch (name){
            case "original sword":
                this.strength=30;
                break;
            case "War Axe":
                this.strength=50;
                break;
            case "Gold Bow":
                this.strength=30;
                break;
            case "little sword":
                this.strength=10;
                break;
            default:
                    System.out.println("this Weapon Not Exist");
        }
    }
}
class Role{
    private String name;
    Weapon w;
    private int blood;
    static int roleNumber=0;
    public int getBlood(){
        return this.blood;
    }
    public static void currRoleNumber(){
        System.out.println("现在还有 "+roleNumber+" 个角色");
    }
    Role(String name,int blood,String weaponName){
        this.name=name;
        this.blood=blood;
        this.w=new Weapon(weaponName);
        roleNumber++;
    }
    public void changeWeapon(String name){
        this.w.changeWeapon(name);
    }
    private void clearRole(){
        System.out.println(this.name+" has Dead");
        this.name=null;
        this.w=null;
        roleNumber--;
        currRoleNumber();
        if(roleNumber<=0){
        System.out.println("Game Over, 角色已经全部阵亡!");
        }
    }
    public void attack(Role r){
        int temp=w.attack();
        r.blood-=temp;
        System.out.println(r.name+" 's blood is "+r.blood);
        //启动自动清除角色功能
        if(r.blood<=0)
            r.clearRole();
    }

}
public class Main {

    public static void main(String[] args) {
        System.out.println("original sword"+" War axe "+" Gold Bow "+" little sword ");
        Role king=new Role("arthur",100,"original sword");
        Role queen=new Role("Elizenbath",80,"little sword");
        Role knight=new Role("Don",110,"original sword");
        Role monster=new Role("satan",400,"War Axe");
        king.attack(monster);
        monster.attack(king);
        queen.attack(monster);
        knight.attack(monster);
        monster.attack(knight);
        monster.attack(queen);
        monster.attack(queen);
        monster.attack(king);
        for(int i=0;i<7;i++)
        knight.attack(monster);
        monster.attack(knight);
        monster.attack(knight);
        //开启自残模式
        while(monster.getBlood()>0)
        monster.attack(monster);
    }
}

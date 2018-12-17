class Person{
    private String name;
    private int age;
    public Person(String name){
        this.name=name;
    }
    //重载构造函数
    public Person(String name,int age){
        this(name);
        this.age=age;
    }
    //重写toString方法
    public String toString(){
        return "name "+this.name+"age: "+this.age;
    }
    //重写了equals方法
    public boolean equals(Object obj){
        //地址相同，直接返回true
        if(this==obj)
            return true;
        //不是Person类
        if(!(obj instanceof Person))
            return false;
        Person per=(Person)obj;
        if(per.name.equals(this.name)&&per.age==this.age)
            return true;
        else
            return false;
    }
}
public class Main {

    public static void main(String[] args) {
        Person p1=new Person("Tom Tonny",10);
        System.out.println(p1.toString());
        Person p2=new Person("Tom Tonny",10);
        System.out.println(p1.equals(p2)?"yes":"no");
        System.out.println(p1.equals("hello")?"yes":"no");
    }
}

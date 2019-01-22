public class StringDemo {
    public static void stringbufferTest(){
        StringBuffer sb1=new StringBuffer();
        System.out.println(sb1.length());
        System.out.println(sb1.capacity());
        StringBuffer sb2=new StringBuffer("123");
        sb2.append("456");
        System.out.println(sb2.length());
        System.out.println(sb2.capacity());
        //一旦length>capacity,则capacity翻倍
        sb2.append("7890123456789");
        System.out.println(sb2.length());
        System.out.println(sb2.capacity());
        sb2.append("1000");
        System.out.println("超出字符的capacity之后");
        System.out.println(sb2.length());
        System.out.println(sb2.capacity());
        sb2.trimToSize();
        System.out.println("给字符串瘦身");
        System.out.println(sb2.length());
        System.out.println(sb2.capacity());
        System.out.println("给字符串设置初始的长度");
        StringBuffer sb3=new StringBuffer(30);
        System.out.println(sb3.capacity());
        System.out.println(sb3.length());
    }
    public static void main(String[]args){
        String s1="A123;456;789;123 ";
        System.out.println(s1.charAt(0));
        System.out.println(s1.indexOf(';'));//返回第一个;的位置
        System.out.println(s1.concat(";000"));//连接";000"，s1不变
        System.out.println(s1.contains("000"));//判断s1是否包含"000"
        System.out.println(s1.endsWith("123 "));//判断是否以"123 "结尾
        System.out.println(s1.equals("123"));
        System.out.println(s1.equalsIgnoreCase("a123;456;789;123 "));
        System.out.println(s1.length());
        System.out.println(s1.trim());
        String[]b=s1.split(";");
        for(String tmp:b)
            System.out.println(tmp);
        System.out.println(s1.substring(2,5));//截断
        //StringBuffer同步，性能好
        //StringBuilder不同步，性能更好
        System.out.println("StringBuffer分割线");
        stringbufferTest();
    }
}

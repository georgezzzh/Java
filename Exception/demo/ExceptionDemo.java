package demo;

public class ExceptionDemo{
    public static void main(String[]args){
       //
        int len=args.length;
        double point=0.0;
        for(String v:args){
            double temp=Double.parseDouble(v);
            if(temp<60)
                point+=0;
            else if(60<=temp&&temp<65)
                point+=1.0;
            else if(65<=temp&&temp<70)
                point+=1.7;
            else if(70<=temp&&temp<75)
                point+=2.2;
            else if(75<=temp&&temp<80)
                point+=2.7;
            else if(80<=temp&&temp<85)
                point+=3.2;
            else if(85<=temp&&temp<90)
                point+=3.6;
            else if(90<=temp&&temp<95)
                point+=3.8;
            else if(95<=temp&&temp<=100)
                point+=4.0;
            else if(temp>100){
                try{
                    throw new Exception("分数不能大于100");
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println("average is "+point/len);
    }
}

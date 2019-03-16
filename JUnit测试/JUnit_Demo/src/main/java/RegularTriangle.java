public class RegularTriangle {
    public boolean isLegal(int a,int b,int c){
        long a1=a;
        long b1=b;
        long c1=c;
        if(a<=0||b<=0||c<=0) return false;
        boolean flag=(a1+b1>c1)&&(b1+c1>a1)&&(a1+c1>b1);
        return flag;
    }
}

import java.util.Random;

class MyRunnable implements Runnable{
    private int sleepTime;
    public void run(){
        go();
        System.out.println("Awake "+sleepTime/1000);
    }
    public void go(){
        try{
            Thread.sleep(this.sleepTime);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public MyRunnable(int sleepTime){
        this.sleepTime=sleepTime;
    }
}
public class SleepThread {
    public static void main(String[]args){
        Random generator=new Random();
        int nums[]=new int[10];
        for(int i=0;i<10;i++){
            nums[i]=generator.nextInt(20);
        }

        Thread threads[]=new Thread[10];
        for(int i=0;i<10;i++){
            threads[i]=new Thread(new MyRunnable(nums[i]*1000));
        }
        for(int i=0;i<10;i++)
            threads[i].start();
        System.out.println("back to main");
    }
}

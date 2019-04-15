public class ThreadDemo {
    public static void main(String[]args){
        Thread th=new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(true){
                    System.out.println("i="+i);
                    i++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        th.start();

    }
}

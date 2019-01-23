import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

public class ListTest {
    public static void main(String[]args){
        //ArrayList和LinkedList都不支持同步
        //Vector支持同步
        ArrayList<Integer> arr=new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        //迭代器的使用
        Iterator<Integer> iter1=arr.iterator();
        while (iter1.hasNext())
            System.out.println(iter1.next());
        //队列的用法s
        LinkedBlockingQueue<Integer> lqueue=new LinkedBlockingQueue<>();
        lqueue.add(999);
        lqueue.add(888);
        while(!lqueue.isEmpty()){
            System.out.println(lqueue.poll());
        }
        //遍历链表
        LinkedList<Integer> myLinkList=new LinkedList<>();
        myLinkList.add(1);
        myLinkList.add(2);
        myLinkList.add(3);
        Iterator<Integer> linkIter=myLinkList.iterator();
        while (linkIter.hasNext())
            System.out.println(linkIter.next());
        //Vector和ArrayList类似，是同步的方法
        Vector<Integer> v=new Vector<>();
        v.add(1);
        v.add(2);
        v.add(3);
        for(int tmp:v){
            System.out.println(tmp);
        }
    }
}

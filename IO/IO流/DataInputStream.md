### 数据操作流 DataOutputStream
把对象写入到文件中
```java
package com.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataOutputStreamDemo {
    //把对象存在文件中
    public static void writeBin(){
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("/home/george/java.log")))
        {
            dos.writeUTF("hello world");
            dos.writeInt(20);;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //从文件中读回对象
    public static void readBin(){
        try(DataInputStream dis=new DataInputStream(new FileInputStream("/home/george/java.log")))
        {
            String str=dis.readUTF();
            int num=dis.readInt();
            System.out.println("Str: "+str);
            System.out.println("Num: "+num);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        writeBin();
        readBin();
    }
}
```
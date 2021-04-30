### 字符流读写文件

以字符流的方式读写文件，向文件中写入文本数据

```java
public class WriterReaderDemo {
    //读取文件
    public static void read(String path) throws IOException {
        File f = new File(path);
        //Reader是构建字符流
        Reader reader = new FileReader(f);
        char [] chars = new char[16];
        int len=-1;
        while((len=reader.read(chars))!=-1){
            System.out.print(new String(chars,0,len));
        }
        reader.close();
    }
    //写入文件
    public static void write(String path) throws IOException{
        File f = new File(path);
        Writer writer = new FileWriter(f);
        writer.write("hello world");
        writer.close();
    }
    public static void main(String[]args){
        try {
            read("/home/george/mentohust.sh");
            write("/home/george/java.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 以字节方式读写文件

```java
public class ByteDemo {
    //字节流的读取方式
    public static void read(String path) throws IOException {
        File file = new File(path);
        InputStream input = new FileInputStream(file);
        byte [] bytes = new byte[30];
        int len = 0;
        while ((len = input.read(bytes))!=-1){
            System.out.print(new String(bytes));
            Arrays.fill(bytes, (byte) 0);
        }
        input.close();
    }
    //字节流写入
    public static void write(String path) throws IOException{
        File file = new File(path);
        OutputStream output = new FileOutputStream(file);
        String str = "二进制文件写入";
        output.write(str.getBytes());
        output.close();
    }
    public static void main(String[]args){
        try{
            read("/home/george/mentohust.sh");
            write("/home/george/java.txt");
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

```

### 字节流实现文件拷贝

```java
public static void copyFile(String source, String target) throws IOException{
        InputStream input = new FileInputStream(source);
        OutputStream output = new FileOutputStream(target);
        byte [] bytes = new byte[16];
        int len = 0;
        while ((len = input.read(bytes))!=-1){
            System.out.print(new String(bytes));
            //写入
            output.write(bytes,0,len);
            //Arrays.fill(bytes, (byte) 0);
        }
        input.close();
        output.close();
}
copyFile("/home/george/mentohust.sh","/home/george/java.txt");
```

### 合并多个字节流

#### SequenceInputStream

```java
//合并流
public static void mergeStream() throws IOException{
    InputStream is1 = new FileInputStream("/home/george/Hello.java");
    InputStream is2 = new FileInputStream("/home/george/java0.log");
    SequenceInputStream seqStream = new SequenceInputStream(is1,is2);
    byte [] bytes =new byte[16];
    //合并了两个字节流，一起读
    while(seqStream.read(bytes)!=-1){
        System.out.print(new String(bytes));
    }
}
```

### 字节流转换为字符流

*  InputStreamReader

```java
public class StreamToReader {
    public static void main(String[]args) throws IOException {
        File f = new File("/home/george/java.log");
        //InputStreamReader接收一个InputStream, 返回Reader
        //实现了从字节流到字符流的转换
        Reader reader = new InputStreamReader(new FileInputStream(f));
        char[] chars = new char[1024];
        int len = reader.read(chars);
        reader.close();
        System.out.println(new String(chars,0,len));
    }
}
```

* OutputStreamWriter

```java
public class StreamToWriter {
    public static void main(String[]args) throws IOException {
        File f = new File("/home/george/java.log");
        // OutputStreamWriter 接收 输入字节流，返回 写入字符流
        Writer writer = new OutputStreamWriter(new FileOutputStream(f));
        writer.write("输入字节流转换为字符流");
        writer.close();
    }
}
```

### Buffered

* BufferedOutputStream

* BufferedInputStream

* BufferedWriter
* BufferedReader

Buffered前缀的类是对普通的类的包装类，增加了一些易用的方法。

例如，BufferedInputStream是对FileInputStream的包装。

```java
BufferedInputStream bfInStream = new BufferedInputStream(new FileInputStream(f));
```

#### BufferedWriter
FileWriter连接到BufferedWriter可以提升效率。

```java
BufferedWriter writer=new BufferedWriter(new FileWriter("hello.txt"));
writer.write("abcdefg");
writer.close();
```
#### BufferedReader
```java
File myFile=new File("foo.txt");
FileReader fileReader=new FileReader(myFile);
BufferedReader reader=new BufferedReader(fileReader);
String line=null;
while((line=reader.readLine())!=null){
    System.out.println(line);
}    
```
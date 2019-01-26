### File类
*File不涉及到具体的文件内容，只涉及属性*  
* .表示当前目录     ..表示上一级目录*


        public class FileTest {
            public static void main(String[]args){
                File d=new File("C:/temp");
                if(!d.exists()){
                    //mkdir()只能单级创建，mkdirs()可以创建递归文件夹
                    d.mkdir();
                }
                System.out.println("Is d directory? "+d.isDirectory());
                File f=new File("C:/temp/abc.txt");
                if(!f.exists()){
                    try{
                        f.createNewFile();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Is f file? "+f.isFile());
                System.out.println("Name: "+f.getName());
                System.out.println("Parent: "+f.getParent());
                System.out.println("Path: "+f.getPath());
                //判断文件的大小，返回字节数
                System.out.println("Size: "+f.length()+" bytes");
                System.out.println("Last modified time: "+f.lastModified()+" ms");
                //遍历d目录下所有的文件信息
                System.out.println("list files in d directory");
                File[]fs=d.listFiles();
                for(File tmp:fs)
                    System.out.println(tmp.getPath());
                //删除文件和文件夹
                f.delete();
                d.delete();
            }
        }
### NIO类
*利用File类移动文件* 

        public class FileTest {
            //创建文件机及其目录
            public static void createFile(){
                File d=new File("C:/temp");
                File d1=new File("C:/temp/test");
                d.mkdir();
                d1.mkdirs();
                File f=new File("C:/temp/abc.txt");
                try{
                    f.createNewFile();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            //移动文件
            public static void moveFile(){
                Path from= Paths.get("C:/temp/abc.txt");
                Path to=from.getParent().resolve("test/def.txt");
                try{
                    System.out.println(Files.size(from));
                    Files.move(from,to, StandardCopyOption.REPLACE_EXISTING);
                }catch (IOException e){
                    System.err.println("移动文件出错, "+e.getMessage());
                }
            }
            public static void main(String[]args){
                createFile();
                moveFile();
            }
        }

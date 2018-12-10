## for-each遍历

    public class Main {
        public static void function1(int i){
            System.out.println("调用"+i);
        }
        public static void main(String[] args) {
            String books[]={"I have to ","say","something words"};
            for(String book:books)
                System.out.println(book);
        }
    }

## 二维数组声明
        String str1[][]=new String[1][1];
        String[0][0]="hello"
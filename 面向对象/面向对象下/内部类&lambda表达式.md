## 内部类
* 定义在其他类内部的类成为内部类。包含内部类的类也被成为外部类。  
* 内部类成员可以直接访问外部类的私有成员。  
* 内部类比外部类多三个修饰符: private、protected、static(外部类不允许使用这三个修饰符)  
* 非静态内部类不允许有静态成员。  
### 非静态内部类

        class DiscerVariable{
            private String prop="外部";
            private class Inclass{
                private String prop="内部类的实例变量";
                public void info(){
                    String prop="局部变量";
                    System.out.println("外部类的类成员: "+DiscerVariable.this.prop);
                    System.out.println("内部类的实例变量: "+this.prop);
                    System.out.println("局部变量: "+prop);
                }
            }
            public void test(){
                Inclass in=new Inclass();
                in.info();
            }
        }
### 静态内部类
如果用static来修饰一个类，则这个内部类就属于外部类本身，而不属于外部类的某个对象。因此称为静态内部类。 

        //使用内部静态类的一个例子
        class StaticClass{
            private int prop1=5;
            private static int prop2=9;
            static class StaticInner{
                private static int age;
                public void accessOuterProp(){
                    //System.out.println(prop1);
                    //只能访问外部类中的静态变量
                    System.out.println(prop2);
                }
            }
            public static void accessInner(){
                new StaticInner().accessOuterProp();
            }
        }
        public class Main {

            public static void main(String[] args) {
                //直接用内部静态类初始化
                StaticClass.StaticInner in=new StaticClass.StaticInner();
                in.accessOuterProp();
            }
        }
## 匿名内部类
最常见的创建匿名内部类的方式时创建某个接口类型的对象。

        interface Product{
            public double getPrice();
            public String getName();
        }
        class Anonymouse{
            public void test(Product p){
                System.out.println("buy a "+p.getName()+", it take my "+p.getPrice());
            }
        }
        public class Main {

            public static void main(String[] args) {
                Anonymouse ata=new Anonymouse();
                //使用匿名内部类
                ata.test(new Product(){
                    public double getPrice(){
                        return 56.2;
                    }
                    public String getName(){
                        return "avg";
                    }
                });

            }
        }
## 给出接口，动态的传入一段代码做具体的处理   
    //作为一个接口，实际中动态的输入一段代码
    interface Command{
    void process(int[]target);
    }
    //一个处理类
    class ProcessArray{
        public void process(int[] target,Command c){
            c.process(target);
        }
    }
    public class Main {
        public static void main(String[] args) {
            int[]array={-1,2,3,4};
            ProcessArray pa=new ProcessArray();
            //动态传入一段代码
            pa.process(array,new Command(){
                public void process(int[]target){
                    int sum=0;
                    for(int tmp:target)
                        sum+=tmp;
                    System.out.println("the sum of array is :"+sum);
                }
            });
        }
    }
## lambda表达式
Lambda表达式的目标类型必须时"函数式接口(function interface)"，函数式接口代表只包含一个抽象方法的接口。函数式接口可以包含多个默认方法，静态方法，但是只能有一个抽象方法。  

**这里给出一个实现Lambda函数的例子**

        interface Eatable{
            void taste();
        }
        interface Echo{
            void echo(int num);
        }
        class Lambda{
            public void eat(Eatable e1){
                e1.taste();
            }
            public void echo(int num,Echo e1){
                e1.echo(num);
            }
        }
        public class Main {
            public static void main(String[] args) {
                Lambda Lam=new Lambda();
                //不带参数的Lambda表达式
                Lam.eat(()->{
                    System.out.println("Eat something!");
                });
                //例如这个echo函数，只有在执行的时候，如果需要转换成二进制，直接匿名实现就可以
                Lam.echo(123,(num)->{
                    System.out.println(Integer.toBinaryString(num));
                });
                //如果需要转换成十六进制，再重写一个即可。
                Lam.echo(123,(num)->{
                    System.out.println(Integer.toHexString(num));
                });
            }
        }



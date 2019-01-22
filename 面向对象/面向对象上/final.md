## final关键字
>使用final修饰基本类型时，不能对基本类型变量重新赋值，因此基本类型变量不能改变。   
但是对于引用类型，它保存的指示一个引用，final只保证这个引用类型变量所修饰的引用地址不会改变，而一直引用同一个对象，但这个对象完全可以发生改变。  

        final int arr[]={1,2,2,10,7};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //修改引用的具体的值可以改变
        arr[1]=0;
        //不能重新修改引用
        arr=null;

* final修饰的形参


       public static void  change(final  int a){
            //被final修饰的参数不能改变
            //  a=3;
           }
* 被final修饰的方法，子类不可以重写
* 被final修饰的类，不可以有继承类
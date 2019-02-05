package com.example.web;
import java.util.ArrayList;

public class BeerExpert {
    public ArrayList getBrands(String color){
        ArrayList brands=new ArrayList();
        //Java中比较字符串==是比较的地址，equals是比较的内容
        if(color.equals("white")){
            brands.add("white color");
            brands.add("super white");
        }
        else{
            brands.add("brown");
            brands.add("brown color");
        }
        return brands;
    }
}

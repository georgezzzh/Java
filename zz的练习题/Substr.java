//package com.demo;
public class Substr{
    public static int countSubstr(String str,String substr){
        int num=0;
        for(int i=0,len=str.length();i<len;i++){
            int temp=i;
            int j=0;
            int len1=substr.length();
            while(j<len1){
                if(str.charAt(temp)==substr.charAt(j)){
                    temp++;
                    j++;
                }else
                    break;
            }
            if(j==len1)
                num++;
        }
        return num;
    }
    public static void main(String[] args){
        String str="javajavaaaa";
        String substr="java";
        int count=countSubstr(str,substr);
        System.out.println(count);
    }
}

package com.msft.contest.pre;
import java.util.Scanner;  

public class Main {  
  
    public static int i,j,k,l,t,n,m;  
    public static String[] a,b;  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Scanner scanner = new Scanner(System.in);  
          
        t = Integer.parseInt(scanner.nextLine());   //案例数  
          
        for(l = 1; l <= t; l++) { //开始转换  
            String number;  
            number = scanner.nextLine();  
            String []nm = number.split(" ");  
            n = Integer.parseInt(nm[0]);  
            m = Integer.parseInt(nm[1]);  
            a = new String[m];  
            b = new String[m];  
            for(i = 0; i < m; i++) {     //得到转换规则  
                String temp;  
                temp = scanner.nextLine();  
                String [] temp1 = temp.split(" ");  
                a[i] = temp1[0];  
                b[i] = temp1[1];  
            }  
            String[] original = scanner.nextLine().split(" ");  //得到原始字符串  
              
            for(i = 0; i < n-1; i++) {  
                for(j = 0; j < original.length; j++) {  
                    original[j] = getRule(original[j]);  
                }  
            }  
              
            System.out.print("Case #" + l + ": " + original[0]);  
            for(i = 1; i < original.length; i++) {  
                System.out.print(" " + original[i]);  
            }  
            System.out.println("");  
              
        }  
        scanner.close();  
    }  
      
    //用于转换字符串  
    public static String getRule(String s){  
        for(int i = 0; i < m ; i++){  
            if(s.equals(a[i]))  
                return b[i];  
        }  
        return s;  
    }  
}  

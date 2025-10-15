package binarytodecimal;

import java.util.Scanner;

public class decimaltobin {
    public static int decitobin(int decimalnum){
        int pow=0;
        int binary=0;
        while(decimalnum>0){
            int rem=decimalnum%2;
            binary+=(rem*Math.pow(10, pow));
            pow++;
            decimalnum/=2;
        }
        return binary;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the decimal number: ");
        int decimalnum=sc.nextInt();
        System.out.println(decitobin(decimalnum));
        sc.close();
    }
}

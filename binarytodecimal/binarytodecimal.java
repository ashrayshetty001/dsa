package binarytodecimal;
import java.util.Scanner;

public class binarytodecimal {
    public static int binarytodeci(int binnum){
        int pow=0;
        int decimalnum=0;
        while(binnum>0){
            int lastdigit=binnum%10;
            decimalnum+=lastdigit*Math.pow(2, pow);
            binnum=binnum/10;
            pow++;
        }
        return decimalnum;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the binary number: ");
        int binnum=sc.nextInt();
        System.out.println(binarytodeci(binnum));
        sc.close();

    }
}

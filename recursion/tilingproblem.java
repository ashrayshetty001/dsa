package recursion;
import java.util.*;
public class tilingproblem{
    public static int tilingproblems(int n){
    if(n==0 ||n==1){
        return 1;
    }
    int fnm1=tilingproblems(n-1);
    int fnm2=tilingproblems(n-2);
    int totways=fnm1+fnm2;
    return totways;
}

public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the width");
    int n=sc.nextInt();
    System.out.println(tilingproblems(n));

}
}

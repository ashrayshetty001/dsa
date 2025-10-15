package bit_manipulation;

public class oddorevenusingbit {
    public static void oddoreven(int n){
        int bitmask=1;
        if((n & bitmask)==0){
            System.out.println("even");
        }
        else{
            System.out.println("odd");
        }
    }
    public static void main(String[] args){
        int n=9;
        oddoreven(n);
    }
}

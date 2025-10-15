package bit_manipulation;

public class ith_bit {
    public static int getithbit(int n,int i){
        int bitmask=1<<i;
        if((n&bitmask)==0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public static int setithbit(int n,int i){
        int bitmask=1<<i;
        return n | bitmask;
    }
    public static void main(String[] args) {
        int result=getithbit(15, 3);
        System.out.println(result);
        int setter=setithbit(15,3);
        System.out.println(setter);
    }
}

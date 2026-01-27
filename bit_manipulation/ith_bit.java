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
    public static int clearithbit(int n,int i){
        int bitmask=~(1<<i);
        return n & bitmask;
    }
    public static void clearlastibits(int n,int i){
        int bitmask=(-1<<i);
        System.out.println(n & bitmask);
    }
    public static void clearinrangebits(int n,int i,int j){
        int a=~0<<(j+1);
        int b=(1<<i)-1;
        int bitmask=a|b;
        System.out.println(n & bitmask);
    }
    public static int updateithbit(int n,int i,int newbit){
        int clearn=clearithbit(n, i);
        int bitmask=newbit<<i;
        return clearn | bitmask;
    }
    public static boolean ispowerof2(int n){
        return (n & (n-1))==0;
    }
    static int countsetbits(int n){
        int count=0;
        while(n>0){
            if((n & 1)!=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
    static int fastexponentiation(int a,int n){//time complexity O(log n)
        int ans=1;
        while(n>0){
            if((n & 1)!=0){
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int result=getithbit(15, 3);
        System.out.println(result);
        int setter=setithbit(15,3);
        System.out.println(setter);
    }
}

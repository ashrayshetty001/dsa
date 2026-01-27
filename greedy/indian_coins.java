package greedy;

public class indian_coins {

    public static void main(String args[]){
        int coins[]={1,2,5,10,20,50,100,500,1000};
        int amount=1234;
        int count=0;

        for(int i=coins.length-1;i>=0;i--){
            if(amount==0){
                break;
            }
            while(amount>=coins[i]){
                amount-=coins[i];
                count++;
            }
        }
        System.out.println("Minimum coins required: "+count);
    }
}

package greedy;
import java.util.*;
public class fractionalknapsack {
    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        
        double ratio[][] = new double[weights.length][2];
        for(int i=0;i<weights.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = values[i] * 1.0 / weights[i];
        }   
        //sorting in descending order based on ratio
        Arrays.sort(ratio,Comparator.comparingDouble(o -> o[1]));
        double totalValue = 0;
        for(int i=0;i<weights.length;i++){
            int idx = (int) ratio[i][0];
            if(weights[idx] <= capacity){
                totalValue += values[idx];
                capacity -= weights[idx];
            }else{
                totalValue += values[idx] * ((double)capacity / weights[idx]);
                break;
            }
        }
        System.out.println("Maximum value in Knapsack = " + totalValue);
    }
}

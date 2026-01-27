package greedy;
import java.util.*;

public class maximum_sum_chain_of_pairs {
    public static void main(String args[]){
        int pairs[][]={{5,24},{15,25},{27,40},{50,60}};
        

        //sorting based on second element of pair using lambda function
        Arrays.sort(pairs,Comparator.comparingInt(a -> a[1]));

        int chainlength=1;
        int currentEnd=pairs[0][1];

        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>currentEnd){
                chainlength++;
                currentEnd=pairs[i][1];
            }
        }
        System.out.println("Maximum sum of chain of pairs: "+chainlength);
    }
}

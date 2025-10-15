package stack;

import java.util.Stack;

public class stock_span {
    public static void calculateSpan(int[] prices,int[] spans){
        Stack<Integer> s=new Stack<>();
        s.push(0);
        spans[0]=1;
        for(int i=1;i<prices.length;i++){
            int currentPrice=prices[i];
            while(!s.isEmpty() && currentPrice>=prices[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                spans[i]=i+1;
            }else{
                spans[i]=i-s.peek();
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = new int[prices.length];
        calculateSpan(prices, spans);
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }

}

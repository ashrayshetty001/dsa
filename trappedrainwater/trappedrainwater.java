public class trappedrainwater{
    public static int trappedwater(int[] height){
        int trappedwaters=0;
        int n=height.length;
        int[] leftmax=new int[n];
        leftmax[0]=height[0];
        for (int i=1;i<=n-1;i++){
            leftmax[i]=Math.max(height[i],leftmax[i-1]);
        }

        int[] rightmax=new int[n];
        rightmax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(height[i],rightmax[i+1]);
        }

        int waterlevel=0;
        for(int i=1;i<=n-2;i++){
            waterlevel=Math.min(leftmax[i],rightmax[i]);
            trappedwaters+=waterlevel-height[i];
        }
        return trappedwaters;
    }

    public static void main(String[] args){
        int height[]={4,2,0,6,3,2};
        System.out.println(trappedwater(height));
    }
}
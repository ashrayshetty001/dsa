public class bubblesort {

    public static void bubblesorting(int[] arr){
        for(int term=0;term<arr.length-1;term++){
            for(int j=0;j<arr.length-1-term;j++){
                if(arr[j]>arr[j+1]){
                    int tem=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tem;
                }
            }
        }
    }
    public static void printarr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args){
        int arr[]={5,4,1,2,3};
        bubblesorting(arr);
        printarr(arr);
    }
}

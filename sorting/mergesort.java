public class mergesort {

    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.err.print(arr[i]+" ");
        }
    }
    public static void mergesorts(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid= (si+ei)/2;
        mergesorts(arr, si,mid);
        mergesorts(arr, mid+1, ei);
        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;
        while(i<=mid &&j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }

        //left out part from left array
        while(i<=mid){
            temp[k++]=arr[i++];
        }

        //left out part from rigth array
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        //copy to original array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    } 

    public static void main(String args[]){
        int arr[]={3,5,2,6,8,4};
        int si=0,ei=arr.length-1;
        mergesorts(arr, si, ei);
        printArray(arr);
    }
}



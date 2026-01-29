package binary_tree;
import java.util.*;
import java.lang.reflect.Array;

public class bst {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left,val);
        }else{
            root.right=insert(root.right,val);
        }
        return root;

    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left,key);
        }else{
            return search(root.right,key);
        }
    }
    public static void printinrange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printinrange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printinrange(root.right,k1,k2);
        }else if(root.data<k1){
            printinrange(root.right,k1,k2);
        }else{
            printinrange(root.left,k1,k2);
        }
    }
    public static void printroot2leaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            for(int i=0;i<path.size();i++){
                System.out.print(path.get(i)+"->");
            }
            System.out.println("null");
        }else{
            printroot2leaf(root.left,path);
            printroot2leaf(root.right,path);
        }
        path.remove(path.size()-1);
    }
    public static boolean validatebst(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }else if(max!=null && root.data>=max.data){
            return false;
        }
        boolean leftvalid=validatebst(root.left,min,root);
        boolean rightvalid=validatebst(root.right,root,max);
        return leftvalid && rightvalid;
    }
    public static Node createmirror(Node root){
        if(root==null){
            return null;
        }
        Node leftmirr=createmirror(root.left);
        Node rightmirr=createmirror(root.right);
        root.left=rightmirr;
        root.right=leftmirr;
        return root;
    }
    public static Node deletenode(Node root,int val){
        if(root.data>val){
            root.left=deletenode(root.left,val);
        }else if(root.data<val){
            root.right=deletenode(root.right,val);
        }else{
            //case1
            if(root.left==null && root.right==null){
                return null;
            }
            //case2
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            //case3
            Node is=getsuccesor(root.right);
            root.data=is.data;
            root.right=deletenode(root.right,is.data);
        }
        return root;
    }
    public static Node getsuccesor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static Node sortedarrtobst(int arr[],int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(arr[mid]);
        root.left=sortedarrtobst(arr,st,mid-1);
        root.right=sortedarrtobst(arr,mid+1,end);
        return root;
        
    }   
    public static class Info {
    boolean isbst;
    int size;
    int min;
    int max;

    public Info(int size, int min, int max, boolean isbst) {
        this.size = size;
        this.min = min;
        this.max = max;
        this.isbst = isbst;
    }

    public static int maxBSTSize = 0;

    public static Info largestBSTinBT(Node root) {
        if (root == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Info leftInfo = largestBSTinBT(root.left);
        Info rightInfo = largestBSTinBT(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (leftInfo.isbst && rightInfo.isbst && root.data > leftInfo.max && root.data < rightInfo.min) {
            maxBSTSize = Math.max(maxBSTSize, size);
            return new Info(size, min, max, true);
        }

        return new Info(size, min, max, false);
    }
}
    
    public static void main(String args[]){
        int arr[]={-10,-3,0,5,9};
        Node root=sortedarrtobst(arr,0,arr.length-1);
        System.out.println(root.data);
    }

}

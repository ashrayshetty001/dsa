package linked_list;
public class linked{    
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static void addFirst(int data){
        if(head==null){
            head=tail;
        }
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }
    public static void mergesort(Node head){
        if(head==null || head.next==null){
            return;
        }
        Node mid=getmid(head);
        Node righthead=mid.next;
        mid.next=null;
        mergesort(head);
        mergesort(righthead);
        Node newhead=merge(head,righthead);
    }
    public static Node merge(Node head1,Node head2){
        Node mergedll=new Node(-1);
        Node temp=mergedll;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedll.next;
    }
    public static Node getmid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static Node zigzag(){
        //find mid
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //reverse 2nd half
        Node curr=slow;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nextL,nextR;
        //zigzag merge
        while(left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }
        return head;
    }
}
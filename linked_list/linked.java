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
}
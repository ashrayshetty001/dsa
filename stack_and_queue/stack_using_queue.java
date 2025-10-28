import java.util.LinkedList;
import java.util.Queue; 
class MyStack {

    public MyStack() {
        Queue<Integer> s1=new LinkedList<>();
        Queue<Integer> s2=new LinkedList<>();
    }

    
    public void push(int x) {
        if(!s1.isEmpty()){
            s1.push(x);
        }
        else{
            s2.push(x);
        }
    }
    
    public int pop() {
        if(s1.isEmpty()){
            return -1;
        }
        if(!s1.isEmpty()){
            while(!s1.isEmpty()){
                int top=s1.remove();
                if(s1.isEmpty()){
                    break;
                }
                s2.add(top);
            }
        }
        else{
            while(!s2.isEmpty()){
                int top=s2.remove();
                if(s2.isEmpty()){
                    break;
                }
                s1.add(top);
            }
        }
    }
    
    public int top() {
        if(!s1.isEmpty()){
            return s1.peek();
        }
        else{
            return s2.peek();
        }
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
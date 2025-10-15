package stack;
import java.util.Stack;
public class duplicate_parentheses {
    public static boolean isDuplicate(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                int count=0;
                while(st.peek()!='('){
                    st.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s1="((a+b))";
        System.out.println(isDuplicate(s1));
    }
}

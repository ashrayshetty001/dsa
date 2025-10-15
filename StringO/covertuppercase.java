package StringO;

public class covertuppercase {
    public static StringBuilder touppercase(String s){
        StringBuilder sb=new StringBuilder("");
        sb.append(Character.toUpperCase(s.charAt(0)));
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ' && i<s.length()-1){
                sb.append(s.charAt(i));
                i++;
                sb.append(Character.toUpperCase(s.charAt(i)));   
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb;
    }
    public static void main(String[] args){
        String s="hi good morning how are you";
        System.out.println(touppercase(s));
    }
}

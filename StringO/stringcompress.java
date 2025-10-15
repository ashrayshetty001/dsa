package StringO;

public class stringcompress {
    public static StringBuilder compressor(String s){
        StringBuilder newsb=new StringBuilder("");
        for(int i=0;i<s.length();i++){
            Integer count=1;
            while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                count++;
                i++;
            }
            newsb.append(s.charAt(i));
            if(count>1){
                newsb.append(count.toString());
            }
        }
        return newsb;
    }
    public static void main(String[] args){
        String s="aaabbbccc";
        System.out.println(compressor(s));
    }
}

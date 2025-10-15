package StringO;
public class substring {
    public static String substring(String s,int si,int ei){
        String sub="";
        for(int i=si;i<ei;i++){
            sub+=s.charAt(i);
        }
        return sub;
    }
    public static void main(String[] args){
        String s="Hellogood morning";
        int si=1,ei=7;
        System.out.println(substring(s, si, ei));
    }
}

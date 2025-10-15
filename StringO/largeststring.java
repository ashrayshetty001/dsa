package StringO;

public class largeststring {
    public static String largest(String[] fruits){
        String Largest="";
        for(int i=0;i<fruits.length;i++){
            if((Largest.compareToIgnoreCase(fruits[i]))<0){
                Largest=fruits[i];
            }
        }
        return Largest;
    }
    public static void main(String[] args){
        String fruits[]={"apple","banana","mango"};
        System.out.println(largest(fruits));
    }
}

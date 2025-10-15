package starpattern;

public class rotatedpyramid {
    public static void rotatedpyramidside(int totrows,int totcols){
        for(int i=1;i<=totrows;i++){
            for(int j=totcols-i;j>=0;j--){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        rotatedpyramidside(6, 5);
    }
}

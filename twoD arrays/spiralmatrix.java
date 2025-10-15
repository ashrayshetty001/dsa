public class spiralmatrix {
    public static void spiral(int[][] matrix){
        int row=0,col=0;
        int rowmax=matrix.length-1,colmax=matrix[0].length-1;
        while(row<=rowmax&&col<=colmax){
            //top
            for(int i=col;i<=colmax;i++){
                System.out.println(matrix[col][i]+" ");
            }
            //right
            for(int i=col+1;i<=colmax;i++){
                System.out.println(matrix[i][colmax]+" ");
            }
            //bottom
            for(int i=colmax-1;i>=col;i--){
                System.out.println(matrix[rowmax][i]+" ");
            }
            //left
            for(int i=rowmax-1;i>row;i--){
                System.out.println(matrix[i][col]+" ");
            }
            row++;
            rowmax--;
            col++;
            colmax--;
        }
        

    }
    public static void main(String[] args){
        int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiral(matrix);
    }
}

import java.util.ArrayList;
import java.util.List;

class SetMatrixZeroes{
    public static void main(String[] args) {
        int[][] matrix={{1,1,1},{1,0,1},{1,1,1}};
        int[][] result=setZeroes(matrix); // [[1,0,1],[0,0,0],[1,0,1]]: 0 at row 2 & column 2
        for(int[] m:matrix){
            for(int n: m){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }
    // https://leetcode.com/problems/set-matrix-zeroes/description/
    public static int[][] setZeroes(int[][] matrix) {
        List<List<Integer>> indexes=new ArrayList<>(); //List to store indexes where element is 0.

        //Traverse accross the list and get indexes where element is 0.
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    List<Integer> zeroIndexes=new ArrayList<>();
                    zeroIndexes.add(i);
                    zeroIndexes.add(j);
                    indexes.add(zeroIndexes);
                }
            }
        }

        for(List<Integer> list: indexes){
            //Replace original matrix column elements to 0 for current row.
            for(int k=0;k<matrix.length;k++){
                matrix[k][(int)list.get(1)]=0;
            }
            //Replace original matrix row elements to 0 for current column.
            for(int l=0;l<matrix[0].length;l++){
                matrix[(int)list.get(0)][l]=0;
            }
        }
        return matrix;
    }
}
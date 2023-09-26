/*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the
    return true if sudoku is valid else return false.
 */
public class ValidSudoku {
    public static void main(String[] args) {

        char[][] elements={{'.','.','.','9','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','3','.','.','.','.','.','1'},{'.','.','.','.','.','.','.','.','.'},{'1','.','.','.','.','.','3','.','.'},{'.','.','.','.','2','.','6','.','.'},{'.','9','.','.','.','.','.','7','.'},{'.','.','.','.','.','.','.','.','.'},{'8','.','.','8','.','.','.','.','.'}};
        System.out.println(isValidSudoku(elements));
    }

    // In this problem we'll validate the sudoku 3 times rows, columns and boxes(By dividing the 3X3 when i & j are first element of sub box)
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                char element= board[i][j];
                
                //Validating in rows
                for(int row=i+1;row<board.length;row++){
                    if(element=='.')//If box element is empty go with next element
                    continue;
                    if(element==board[row][j]) //If we find duplicate in the row return false
                    return false;
                }

                //Validating in columns
                for(int column=j+1;column<board[i].length;column++){
                    System.out.println("COlumn validation: "+" Element: "+element+"[i][column]: "+board[i][column]);
                    if(element=='.') //If box element is empty go with next element
                    continue;
                    if(element==board[i][column])//If we find duplicate in the column return false
                    return false;
                }
                
                //Validating box 3X3
                //Entering into 3X3 box only when it is first element in the box by taking mod for i & j
                if(i%3==0 && j%3==0 ){
                    for(int row=i;row<=i+2; row++){
                        for(int column=j;column<=j+2;column++){
                            char subElement=board[row][column]; //Elment of 3X3 box
                            if(subElement=='.') //If element of 3X3 is empty continue with next element
                            continue;
                            int count=1; //Keeping count of element occurance inclusive
                            for(int subRow=i;subRow<=i+2;subRow++){
                                for(int subColumn=j;subColumn<=j+2; subColumn++){
                                    if(subElement==board[subRow][subColumn]) //If duplicate element
                                    count++;
                                    if(count>2) //If element occurs more than 2 return false
                                        return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}

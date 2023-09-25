/*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the
    return true if sudoku is valid else return false.
 */
public class ValidSudoku {
    public static void main(String[] args) {

        char[][] elements={{'5','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(elements));
    }

    public static boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length-1;i++){
            for(int j=0;j<board[i].length-1;j++){
                char element= board[i][j];
                if(element=='.')
                continue;
                //Validating in rows
                for(int row=i+1;row<board.length;row++){
                    if(element==board[i][row])
                    return false;
                }
                //Validating in columns
                for(int column=j+1;column<board[i].length;column++){
                    if(element==board[column][i])
                    return false;
                }
                //Validating box

            }
        }
        return true;
    }
}


import java.util.HashSet;

public class valid_sudoku_36 {

    public static void main(String[] args) {
        var sol = new Solution_36();
        var res = sol.isValidSudoku(new char[][]{
            {'7', '.', '.', '.', '.', '.', '2', '.', '.'},
            {'4', '.', '2', '.', '.', '.', '.', '.', '3'},
            {'.', '.', '.', '2', '.', '1', '.', '.', '.'},
            {'3', '.', '.', '1', '8', '.', '.', '9', '7'},
            {'.', '.', '9', '.', '7', '.', '6', '.', '.'},
            {'6', '5', '.', '.', '3', '2', '.', '.', '1'},
            {'.', '.', '.', '4', '.', '9', '.', '.', '.'},
            {'5', '.', '.', '.', '.', '.', '1', '.', '6'},
            {'.', '.', '6', '.', '.', '.', '.', '.', '8'}
        });
        System.out.printf("The result is %b %n", res);
    }
}

// Optimal Solution
class Solution_36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                char ch = board[RowIndex + j / 3][ColIndex + j % 3];
                if (ch != '.' && !cube.add(ch)) {
                    return false;
                }
            }
        }
        return true;
    }
}
// First Solution
// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         if (board.length == 0 || board[0].length == 0) return false;

//         return validRows(board) && validColumns(board) && validBoxes(board);
//     }
    
//     boolean validRows(char[][] arr) {
        
//         for (int i = 0; i < arr.length; i++) {
//             var set = new HashSet<Character>();
//             for (int j = 0; j < arr[0].length; j++) {
//                 var ch = arr[i][j];
//                 if (set.contains(ch)) {
//                     return false;
//                 }
//                 if (ch != '.') {
//                     set.add(ch);
//                 }
//             }
//         }
//         return true;
//     }

//     boolean validColumns(char[][] arr) {
//         for (int i = 0; i < arr.length; i++) {
//             var set = new HashSet<Character>();
//             for (int j = 0; j < arr[0].length; j++) {
//                 var ch = arr[j][i];
//                 if (set.contains(ch)) {
//                     return false;
//                 }
//                 if (ch != '.') {
//                     set.add(ch);
//                 }
//             }
//         }
//         return true;
//     }

//     boolean validBoxes(char[][] arr) {
//         for (int box_row = 0; box_row < 3; box_row++) {
//             for (int box_col = 0; box_col < 3; box_col++) {
//                 var set = new HashSet<Character>();
//                 for (int i = 0; i < 3; i++) {
//                     for (int j = 0; j < 3; j++) {
//                         var ch = arr[box_row * 3 + i][box_col * 3 + j];
//                         if (set.contains(ch)) {
//                             return false;
//                         }
//                         if (ch != '.') {
//                             set.add(ch);
//                         }
//                     }
//                 }
//             }
//         }
//         return true;
//     }
// }
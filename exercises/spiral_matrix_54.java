import java.util.ArrayList;
import java.util.List;

// Original Solution
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (!(left <= right && top <= bottom)) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}

// Optimized Solution but more complex
// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         List<Integer> res = new ArrayList<>();
//         int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//         int[] steps = {matrix[0].length, matrix.length - 1};
//
//         int r = 0, c = -1, d = 0;
//         while (steps[d % 2] > 0) {
//             for (int i = 0; i < steps[d % 2]; i++) {
//                 r += directions[d][0];
//                 c += directions[d][1];
//                 res.add(matrix[r][c]);
//             }
//             steps[d % 2]--;
//             d = (d + 1) % 4;
//         }
//         return res;
//     }
// }

/*
1    2    3    4    5

6    7    8    9    10

11   12   13   14   15

16   17   18   19   20

21   22   23   24   25
*/


// For each row (well actually up to the middle row) only half
// Then do one loop from left to right (leave out the last value)
// Then another from up to down
// Then another from right to left
// Then another from down to up



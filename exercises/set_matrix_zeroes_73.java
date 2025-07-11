class Solution {
    public void setZeroes(int[][] matrix) {
		boolean[] x_axis = new boolean[matrix[0].length];
		boolean[] y_axis = new boolean[matrix.length];
		// First find all zeroes and turn its x and y to true
		for (int i = 0; i < y_axis.length; i++) {
			for (int j = 0; j < x_axis.length; j++) {
				if (matrix[i][j] == 0) {
					y_axis[i] = true;
					x_axis[j] = true;
				}
			}
		}
		// Then for every cell check if its x or y is true and if so turn it into 0
		for (int i = 0; i < y_axis.length; i++) {
			for (int j = 0; j < x_axis.length; j++) {
				if (x_axis[j] || y_axis[i]) {
					matrix[i][j] = 0;
				}
			}
		}

    }
}

// Space optimized solution using a trick where we use the first row and column as flags
// public class Solution {
//     public void setZeroes(int[][] matrix) {
//         int ROWS = matrix.length, COLS = matrix[0].length;
//         boolean rowZero = false;
//
//         for (int r = 0; r < ROWS; r++) {
//             for (int c = 0; c < COLS; c++) {
//                 if (matrix[r][c] == 0) {
//                     matrix[0][c] = 0;
//                     if (r > 0) {
//                         matrix[r][0] = 0;
//                     } else {
//                         rowZero = true;
//                     }
//                 }
//             }
//         }
//
//         for (int r = 1; r < ROWS; r++) {
//             for (int c = 1; c < COLS; c++) {
//                 if (matrix[0][c] == 0 || matrix[r][0] == 0) {
//                     matrix[r][c] = 0;
//                 }
//             }
//         }
//
//         if (matrix[0][0] == 0) {
//             for (int r = 0; r < ROWS; r++) {
//                 matrix[r][0] = 0;
//             }
//         }
//
//         if (rowZero) {
//             for (int c = 0; c < COLS; c++) {
//                 matrix[0][c] = 0;
//             }
//         }
//     }
// }


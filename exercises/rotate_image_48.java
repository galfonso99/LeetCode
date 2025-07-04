// Normal approach. From first row to middle row and for each column except the last one
// Perform a 4 corner swap of the elements (As j increases the corner shifts)
class Solution {
    public void rotate(int[][] matrix) {
        var length = matrix.length - 1;
		var width = matrix[0].length - 1;
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = i; j < matrix[0].length - 1 - i; j++) {
				var tmp = matrix[i][j];
				matrix[i][j] = matrix[length - j][i];
				matrix[length - j][i] = matrix[length - i][width - j];
				matrix[length - i][width - j] = matrix[j][width - i];
				matrix[j][width - i] = tmp;
			}
		}
    }
}

// for each row (only half)
// 	for each element in the row
// 		rotate the four corners 90 degrees

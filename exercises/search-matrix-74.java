 // Straightforward solution from someone else, probably better for interviews
 //I think my solution was O(logn + logm) while this one is O(log(n*m))
class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int l = 0;
		int r = n * m - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			int midValue = matrix[mid / n][mid % n];
			if (target < midValue) {
				r = mid - 1;
			} else if (target > midValue) {
				l = mid + 1;
			} else {
				return true;
			}
		}
		return false;
    }
}

// My Solution (Its not bad, but more lines equals worse I guess?)
//class Solution {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int searchRow = 0;
//        int t = 0;
//        int b = n - 1;
//        while (t <= b) {
//            int middleRow = t + (b - t) / 2;
//            int start = matrix[middleRow][0];
//            int end = matrix[middleRow][m-1];
//            if (target < start) {
//                b = middleRow - 1;
//            } else if (target > end) {
//                t = middleRow + 1;
//            } else {
//                searchRow = middleRow;
//                break;
//            }
//        }
//        int l = 0;
//        int r = m - 1;
//        while (l <= r) {
//            int middle = l + (r - l) / 2;
//            int curr = matrix[searchRow][middle];
//            if (target < curr) {
//                r = middle - 1;
//            } else if (target > curr) {
//                l = middle + 1;
//            } else {
//                return true;
//            }
//        }
//        return false;
//
//    }
//}


// INSTRUCTIONS
//74. Search a 2D Matrix
//You are given an m x n integer matrix matrix with the following two properties:
//
//    Each row is sorted in non-decreasing order.
//    The first integer of each row is greater than the last integer of the previous row.
//
//Given an integer target, return true if target is in matrix or false otherwise.
//
//You must write a solution in O(log(m * n)) time complexity.
//
//
//
//Example 1:
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
//
//Example 2:
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
//
//
//
//Constraints:
//
//    m == matrix.length
//    n == matrix[i].length
//    1 <= m, n <= 100
//    -104 <= matrix[i][j], target <= 104
//


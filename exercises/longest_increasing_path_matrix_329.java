// Insanely good optimizations from the original
class Solution {
    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int result = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, solve(matrix, dp, i, j));
            }
        }
        return result;
    }
    
    private int solve(int[][] matrix, int[][] dp, int y, int x) {
        if (dp[y][x] != 0) return dp[y][x];
        
        int m = matrix.length, n = matrix[0].length;
        int maxPath = 1;
        for (int[] dir : DIRS) {
            int dy = y + dir[0];
            int dx = x + dir[1];
            if (dy >= 0 && dy < m && dx >= 0 && dx < n && matrix[y][x] < matrix[dy][dx]) {
                maxPath = Math.max(maxPath, 1 + solve(matrix, dp, dy, dx));
            }
        }
        return dp[y][x] = maxPath;
    }
}

// Original working solution
// class Solution {
// 	int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//     public int longestIncreasingPath(int[][] matrix) {
// 		int[][] dp = new int[matrix.length][matrix[0].length];
// 		int result = 0;
// 		for (int i = 0; i < dp.length; i++) {
// 			for (int j = 0; j < dp[0].length; j++) {
// 				int path = solve(matrix, dp, i, j);
// 				if (path > result) { result = path; }
// 			}
// 		}
// 		return result + 1;
//     }
//
// 	int solve(int[][] matrix, int[][] dp, int y, int x) {
// 		if (dp[y][x] != 0) return dp[y][x];
// 		for (int[] dir : DIRS) {
// 			int dy = y + dir[0];
// 			int dx = x + dir[1];
// 			if (dy < 0 || dy >= matrix.length || dx < 0 || dx >= matrix[0].length) {
// 				continue;
// 			}
// 			if (matrix[y][x] < matrix[dy][dx]) {
// 				int path = 1 + solve(matrix, dp, dy, dx);
// 				if (dp[y][x] < path) { dp[y][x] = path; }
// 			}
// 		}
// 		return dp[y][x];
// 	}
// }

// Similar to the original but keeping a prevValue
// public class Solution {
//     int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//     int[][] dp;
//
//     private int dfs(int[][] matrix, int r, int c, int prevVal) {
//         int ROWS = matrix.length, COLS = matrix[0].length;
//         if (r < 0 || r >= ROWS || c < 0 ||
//             c >= COLS || matrix[r][c] <= prevVal) {
//             return 0;
//         }
//         if (dp[r][c] != -1) return dp[r][c];
//
//         int res = 1;
//         for (int[] d : directions) {
//             res = Math.max(res, 1 + dfs(matrix, r + d[0],
//                                     c + d[1], matrix[r][c]));
//         }
//         return dp[r][c] = res;
//     }
//
//     public int longestIncreasingPath(int[][] matrix) {
//         int ROWS = matrix.length, COLS = matrix[0].length;
//         int LIP = 0;
//         dp = new int[ROWS][COLS];
//         for (int i = 0; i < ROWS; i++) {
//             for (int j = 0; j < COLS; j++) {
//                 dp[i][j] = -1;
//             }
//         }
//         for (int r = 0; r < ROWS; r++) {
//             for (int c = 0; c < COLS; c++) {
//                 LIP = Math.max(LIP, dfs(matrix, r, c, Integer.MIN_VALUE));
//             }
//         }
//         return LIP;
//     }
// }

// Topological Sort (Kahn's Algorithm)
// public class Solution {
//     public int longestIncreasingPath(int[][] matrix) {
//         int ROWS = matrix.length, COLS = matrix[0].length;
//         int[][] indegree = new int[ROWS][COLS];
//         int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//         for (int r = 0; r < ROWS; ++r) {
//             for (int c = 0; c < COLS; ++c) {
//                 for (int[] d : directions) {
//                     int nr = r + d[0], nc = c + d[1];
//                     if (nr >= 0 && nr < ROWS && nc >= 0 &&
//                         nc < COLS && matrix[nr][nc] < matrix[r][c]) {
//                         indegree[r][c]++;
//                     }
//                 }
//             }
//         }
//
//         Queue<int[]> q = new LinkedList<>();
//         for (int r = 0; r < ROWS; ++r) {
//             for (int c = 0; c < COLS; ++c) {
//                 if (indegree[r][c] == 0) {
//                     q.offer(new int[]{r, c});
//                 }
//             }
//         }
//
//         int LIS = 0;
//         while (!q.isEmpty()) {
//             int size = q.size();
//             for (int i = 0; i < size; ++i) {
//                 int[] node = q.poll();
//                 int r = node[0], c = node[1];
//                 for (int[] d : directions) {
//                     int nr = r + d[0], nc = c + d[1];
//                     if (nr >= 0 && nr < ROWS && nc >= 0 &&
//                         nc < COLS && matrix[nr][nc] > matrix[r][c]) {
//                         if (--indegree[nr][nc] == 0) {
//                             q.offer(new int[]{nr, nc});
//                         }
//                     }
//                 }
//             }
//             LIS++;
//         }
//         return LIS;
//     }
// }

// Dynamic programming solution using 2D memoization (Solved by me without outside help) [Took some time]
class Solution {
    public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		return rec(dp, 0, 0);
    }

	int rec(int[][] dp, int y, int x) {
		if (y == dp.length - 1 && x == dp[0].length - 1) { return 1; }
		if (dp[y][x] != 0) return dp[y][x];
		dp[y][x] = rec(dp, y+1, x) + rec(dp, y, x+1);
		return dp[y][x];
	}
}
// Original solution (Brute Force - fails to time limit)
// class Solution {
//     public int uniquePaths(int m, int n) {
// 		return rec(0, 0, m, n);
//     }
//
// 	int rec(int y, int x, int m, int n) {
// 		if (y == m - 1 || x == n - 1) { return 1; }
// 		if (y == m || x == n) return 0;
// 		return rec(y+1, x, m, n) + rec(y, x+1, m, n);
// 	}
// }


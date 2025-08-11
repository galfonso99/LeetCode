import java.util.Arrays;

// Original working solution || Check Iterative also (Its pretty clear and instructive)
// Check all the other solution, this early naive solution lacks early pruning for good performance
class Solution {
    public int numDistinct(String s, String t) {
		int dp[][] = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
		return solve(s, t, dp, 0, 0);
    }
	int solve(String string, String target,int[][] dp, int s, int t) {
		if (t == target.length()) return 1;
        if (s == string.length()) return 0;

		if (dp[s][t] != -1) return dp[s][t];
		int take = 0;
		if (string.charAt(s) == target.charAt(t)) {
			take = solve(string, target, dp, s+1, t+1);
		}
		int skip = solve(string, target, dp, s+1, t);
		dp[s][t] = take + skip;
		return dp[s][t];
	}
}

// Iterative
// public class Solution {
//     public int numDistinct(String s, String t) {
//         int m = s.length(), n = t.length();
//         int[][] dp = new int[m + 1][n + 1];
//
//         for (int i = 0; i <= m; i++) {
//             dp[i][n] = 1;
//         }
//
//         for (int i = m - 1; i >= 0; i--) {
//             for (int j = n - 1; j >= 0; j--) {
//                 dp[i][j] = dp[i + 1][j];
//                 if (s.charAt(i) == t.charAt(j)) {
//                     dp[i][j] += dp[i + 1][j + 1];
//                 }
//             }
//         }
//
//         return dp[0][0];
//     }
// }

// Optimized original solution
// class Solution {
//     public int numDistinct(String s, String t) {
//         char[] sArr = s.toCharArray();
//         char[] tArr = t.toCharArray();
//         int dp[][] = new int[sArr.length + 1][tArr.length + 1];
//         for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
//         return solve(sArr, tArr, dp, 0, 0);
//     }
//
//     int solve(char[] string, char[] target, int[][] dp, int s, int t) {
//         if (t == target.length) return 1;
//         if (s == string.length) return 0;
//
//         if (dp[s][t] != -1) return dp[s][t];
//         if (string.length - s < target.length - t) return dp[s][t] = 0;
//         int result = solve(string, target, dp, s + 1, t); 
//         if (string[s] == target[t]) {
//             result += solve(string, target, dp, s + 1, t + 1);
//         }
//         return dp[s][t] = result;
//     }
// }

// Minimally optimized original solution with the fewest changes that yields the biggest
// performance gains | Beats 99.54% at 3ms
// class Solution {
//     public int numDistinct(String s, String t) {
// 		int dp[][] = new int[s.length() + 1][t.length() + 1];
// 		for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
// 		return solve(s, t, dp, 0, 0);
//     }
// 	int solve(String string, String target,int[][] dp, int s, int t) {
// 		if (t == target.length()) return 1;
//         if (s == string.length()) return 0;
//
// 		if (dp[s][t] != -1) return dp[s][t];
// 		if (string.length() - s < target.length() - t) return dp[s][t] = 0;
// 		int take = 0;
// 		if (string.charAt(s) == target.charAt(t)) {
// 			take = solve(string, target, dp, s+1, t+1);
// 		}
// 		int skip = solve(string, target, dp, s+1, t);
// 		dp[s][t] = take + skip;
// 		return dp[s][t];
// 	}
// }


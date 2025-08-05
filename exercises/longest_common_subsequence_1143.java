import java.util.Arrays;

// Bottom Up approach (Iterative - Fastest Solution Overall) Beats 99%
class Solution {
	public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        
		// Space can be reduced by using a prev and curr array making it 1D instead of 2D
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (s1[i-1] == s2[j-1]) ? 
                    dp[i-1][j-1] + 1 :
                    Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }
}

// Original Solution Top down approach ( recursion )
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int[][] dp = new int[text1.length()][text2.length()];
//         for (var row : dp) Arrays.fill(row, -1);
//         return rec(dp, text1, text2, text1.length()-1, text2.length()-1);
//     }
//     int rec(int[][] dp, String text1, String text2, int i, int j) {
//         if (i < 0 || j < 0) return 0;
//         if (dp[i][j] != -1) return dp[i][j];
//         if (text1.charAt(i) == text2.charAt(j)) {
//             dp[i][j] = 1 + rec(dp, text1, text2, i-1, j-1);
//         } else {
//             dp[i][j] = Math.max(rec(dp, text1, text2, i-1, j), rec(dp, text1, text2, i, j-1));
//         }
//         return dp[i][j];
//     }
// }


// Optimized Top down approach
// class Solution {    
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();
//         if (m > n) {
//             return longestCommonSubsequence(text2, text1);
//         }
//         char[] s1 = text1.toCharArray();
//         char[] s2 = text2.toCharArray();
//
//         int[][] dp = new int[m][n];
//         for (int[] row : dp) Arrays.fill(row, -1);
//
//         return solve(s1, s2, m-1, n-1, dp);
//     }
//
//     private int solve(char[] s1, char[] s2, int i, int j, int[][] dp) {
//         if (i < 0 || j < 0) return 0;
//         if (dp[i][j] != -1) return dp[i][j];
//
//         return dp[i][j] = (s1[i] == s2[j]) ? 
//             1 + solve(s1, s2, i-1, j-1, dp) :
//             Math.max(solve(s1, s2, i-1, j, dp), solve(s1, s2, i, j-1, dp));
//     }
// }

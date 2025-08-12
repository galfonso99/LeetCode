// import java.util.Arrays;

class Solution {
    public int minDistance(String word1, String word2) {
		int dp[][] = new int[word1.length()+1][word2.length()+1];
		return solve(dp, word1, word2, 0, 0);
    }

	int solve(int[][] dp, String s1, String s2, int i1, int i2) {
		if (i2 == s2.length()) return s1.length() - i1;
		if (i1 == s1.length()) return s2.length() - i2;
		if (dp[i1][i2] != 0) return dp[i1][i2];

		if (s1.charAt(i1) == s2.charAt(i2)) 
            return dp[i1][i2] = solve(dp, s1, s2, i1+1, i2+1);
		int replace = 1 + solve(dp, s1, s2, i1+1, i2+1);
		int remove = 1 + solve(dp, s1, s2, i1+1, i2);
		int insert = 1 + solve(dp,s1, s2, i1, i2+1);

		return dp[i1][i2] = Math.min(replace, 
					        Math.min(remove, insert));
	}
}

// Iterative (Slower than recursive this time which is quite rare)
// public class Solution {
//     public int minDistance(String word1, String word2) {
//         int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//
//         for (int j = 0; j <= word2.length(); j++) {
//             dp[word1.length()][j] = word2.length() - j;
//         }
//         for (int i = 0; i <= word1.length(); i++) {
//             dp[i][word2.length()] = word1.length() - i;
//         }
//
//         for (int i = word1.length() - 1; i >= 0; i--) {
//             for (int j = word2.length() - 1; j >= 0; j--) {
//                 if (word1.charAt(i) == word2.charAt(j)) {
//                     dp[i][j] = dp[i + 1][j + 1];
//                 } else {
//                     dp[i][j] = 1 + Math.min(dp[i + 1][j],
//                                    Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
//                 }
//             }
//         }
//         return dp[0][0];
//     }
// } 

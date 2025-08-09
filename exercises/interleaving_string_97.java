
// First working solution (Fast enough)

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
		return solve(dp, s1, s2, s3, 0, 0, 0);
    }

	boolean solve(Boolean[][] dp, String s1, String s2, String s3, int i1, int i2, int i3) {
		if (i3 == s3.length() && i1 == s1.length() && i2 == s2.length()) return true;

		if (dp[i1][i2] != null) return dp[i1][i2];

        boolean first = false;
		if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
			first = solve(dp, s1, s2, s3, i1+1, i2, i3+1);
		}
        boolean second = false;
		if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
			second = solve(dp, s1, s2, s3, i1, i2+1, i3+1);
		}
        dp[i1][i2] = first || second;
        return dp[i1][i2];
	}
}

// Minimal optimizations to the original
// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         if (s1.length() + s2.length() != s3.length()) return false;
//         int[][] dp = new int[s1.length()+1][s2.length()+1];
//         for (int i = 0; i <= s1.length(); i++) Arrays.fill(dp[i], -1);
//         char[] c1 = s1.toCharArray();
//         char[] c2 = s2.toCharArray();
//         char[] c3 = s3.toCharArray();
// 		return solve(dp, c1, c2, c3, 0, 0, 0) == 1;
//     }
// 	int solve(int[][] dp, char[] c1, char[] c2, char[] c3, int i1, int i2, int i3) {
// 		if (i3 == c3.length && i1 == c1.length && i2 == c2.length) return 1;
// 		if (dp[i1][i2] != -1) return dp[i1][i2];
//         int first = 0;
// 		if (i1 < c1.length && c1[i1] == c3[i3]) {
// 			first = solve(dp, c1, c2, c3, i1+1, i2, i3+1);
// 		}
//         int second = 0;
// 		if (i2 < c2.length && c2[i2] == c3[i3]) {
// 			second = solve(dp, c1, c2, c3, i1, i2+1, i3+1);
// 		}
//         dp[i1][i2] = (first == 1 || second == 1) ? 1 : 0;
//         return dp[i1][i2];
// 	}
// }

// Iterative Solution
// public class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         int m = s1.length(), n = s2.length();
//         if (m + n != s3.length()) {
//             return false;
//         }
//
//         boolean[][] dp = new boolean[m + 1][n + 1];
//         dp[m][n] = true;
//
//         for (int i = m; i >= 0; i--) {
//             for (int j = n; j >= 0; j--) {
//                 if (i < m && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
//                     dp[i][j] = true;
//                 }
//                 if (j < n && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
//                     dp[i][j] = true;
//                 }
//             }
//         }
//         return dp[0][0];
//     }
// }

// Spaced Optimized Iterative Solution
// public class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         int m = s1.length(), n = s2.length();
//         if (m + n != s3.length()) return false;
//         if (n < m) {
//             String temp = s1;
//             s1 = s2;
//             s2 = temp;
//             int tempLength = m;
//             m = n;
//             n = tempLength;
//         }
//
//         boolean[] dp = new boolean[n + 1];
//         dp[n] = true;
//         for (int i = m; i >= 0; i--) {
//             boolean[] nextDp = new boolean[n + 1];
//             nextDp[n] = true;
//             for (int j = n; j >= 0; j--) {
//                 if (i < m && s1.charAt(i) == s3.charAt(i + j) && dp[j]) {
//                     nextDp[j] = true;
//                 }
//                 if (j < n && s2.charAt(j) == s3.charAt(i + j) && nextDp[j + 1]) {
//                     nextDp[j] = true;
//                 }
//             }
//             dp = nextDp;
//         }
//         return dp[0];
//     }
// }

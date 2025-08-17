// Slightly optimized Original Solution
class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
		return solve(dp, s, p, 0, 0);
    }

	boolean solve(Boolean[][] dp, String s, String p, int i1, int i2) {
        if (i2 == p.length()) return i1 == s.length();
        if (dp[i1][i2] != null) return dp[i1][i2];

		boolean matches = i1 < s.length() && (s.charAt(i1) == p.charAt(i2) || p.charAt(i2) == '.');
		boolean wildcard = i2 + 1 < p.length() && p.charAt(i2 + 1) == '*';

        if (wildcard) {
            dp[i1][i2] = solve(dp, s, p, i1, i2 + 2) || 
                        (matches && solve(dp, s, p, i1 + 1, i2));
        } else {
            dp[i1][i2] = matches && solve(dp, s, p, i1 + 1, i2 + 1);
        }
        return dp[i1][i2];
	}
}


// Original Solution (Before any logic optimizations -- very messy)
// class Solution {
//     public boolean isMatch(String s, String p) {
//         Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
// 		return solve(dp, s, p, 0, 0);
//     }
//
// 	boolean solve(Boolean[][] dp, String s, String p, int i1, int i2) {
//         if (i1 == s.length() && i2 == p.length()) return true;
//         if (i1 == s.length() && i2 == p.length() - 2 && p.charAt(i2 + 1) == '*') return true;
//         if (i2 >= p.length()) return false;
//
// 		boolean wildcard = i2 + 1 < p.length() && p.charAt(i2 + 1) == '*';
//
//         if (i1 == s.length() && wildcard) {
//             dp[i1][i2] = solve(dp, s, p, i1, i2 + 2);
//             return dp[i1][i2];
//         } else if (i1 == s.length() && !wildcard) {
//             dp[i1][i2] = false;
//             return dp[i1][i2];
//         }
//
//         char c1 = s.charAt(i1);
// 		char c2 = p.charAt(i2);
//
// 		boolean matches = c1 == c2 || c2 == '.';
//
//         if (dp[i1][i2] != null) return dp[i1][i2];
//
//         if (!matches && !wildcard) {
//             dp[i1][i2] = false;
//         } else if (matches && wildcard) {
//             // Two options
//             dp[i1][i2] = solve(dp, s, p, i1 + 1, i2) || solve(dp, s, p, i1, i2 + 2);
//         } else if (matches && !wildcard) {
//             dp[i1][i2] = solve(dp, s, p, i1 + 1, i2 + 1);
//         } else {  // Only option left if that it doesnt match but has wildcard next
//             dp[i1][i2] = solve(dp, s, p, i1, i2 + 2);
//         }
//         return dp[i1][i2];
// 	}
// }



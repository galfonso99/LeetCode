// O(n)
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);

        return dfs(s, 0, dp);
    }

    private int dfs(String s, int i, Map<Integer, Integer> dp) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        if (s.charAt(i) == '0') {
            return 0;
        }

        int res = dfs(s, i + 1, dp);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || 
           s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += dfs(s, i + 2, dp);
        }
        dp.put(i, res);
        return res;
    }
}

// Bottom up approach
// public class Solution {
//     public int numDecodings(String s) {    
//         int[] dp = new int[s.length() + 1];
//         dp[s.length()] = 1;
//         for (int i = s.length() - 1; i >= 0; i--) {
//             if (s.charAt(i) == '0') {
//                 dp[i] = 0;
//             } else {
//                 dp[i] = dp[i + 1];
//                 if (i + 1 < s.length() && (s.charAt(i) == '1' || 
//                     s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
//                     dp[i] += dp[i + 2];
//                 }
//             }
//         }
//         return dp[0];
//     }
// }

// Space complexity O(2^n)
// class Solution {
// 	private int dfs(int i, String s) {
// 		if (i == s.length()) return 1;
// 		if (s.charAt(i) == '0') return 0;
//
// 		int res = dfs(i + 1, s);
//         if (i < s.length() - 1) {
//             if (s.charAt(i) == '1' || 
//                (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
//                 res += dfs(i + 2, s);
//             }
//         }
//         return res;
//     }
//
//     public int numDecodings(String s) {
//         return dfs(0, s);
//     }
// }


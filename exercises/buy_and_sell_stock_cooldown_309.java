import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Recursive Solution (Slower)
class Solution {
    public int maxProfit(int[] prices) {
		int dp[][] = new int[2][prices.length];
        return dfs(dp, 0, 1, prices);
    }
    
    private int dfs(int[][] dp, int i, int buying, int[] prices) {
        if (i >= prices.length) { return 0; }
        if (dp[buying][i] != 0) { return dp[buying][i]; }

        int cooldown = dfs(dp, i + 1, buying, prices);
        if (buying == 1) {
            int buy = dfs(dp, i + 1, 0, prices) - prices[i];
			dp[buying][i] = Math.max(buy, cooldown);
        } else {
            int sell = dfs(dp, i + 2, 1, prices) + prices[i];
			dp[buying][i] = Math.max(sell, cooldown);
        }

        return dp[buying][i];
    }
}

// Bottom up Approach (Iterative)
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n + 1][2];  
//
//         for (int i = n - 1; i >= 0; i--) {
//             for (int buying = 1; buying >= 0; buying--) {
//                 if (buying == 1) {
//                     int buy = dp[i + 1][0] - prices[i];
//                     int cooldown = dp[i + 1][1];
//                     dp[i][1] = Math.max(buy, cooldown);
//                 } else {
//                     int sell = (i + 2 < n) ? dp[i + 2][1] + prices[i] : prices[i];
//                     int cooldown = dp[i + 1][0];
//                     dp[i][0] = Math.max(sell, cooldown);
//                 }
//             }
//         }
//
//         return dp[0][1];
//     }
// }

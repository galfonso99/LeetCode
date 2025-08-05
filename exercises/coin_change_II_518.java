import java.util.Arrays;

// Iterative
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int a = 0; a <= amount; a++) {
                if (a >= coins[i]) {
                    dp[i][a] = dp[i + 1][a];
                    dp[i][a] += dp[i][a - coins[i]];
                }
            }
        }
        return dp[0][amount];
    }
}

// Good Enough recursive solution (Still very slow compared to iterative) 11ms
// class Solution {
//     public int change(int amount, int[] coins) {
// 		int dp[][] = new int[coins.length + 1][amount + 1];
//         for (int i = 0; i <= coins.length; i++) Arrays.fill(dp[i], -1);
//         Arrays.sort(coins);
//         // Hack to mock a reversed sort (Java has no reversed sort for int type)
//         for (int i = 0; i < coins.length / 2; i++) {
//             int temp = coins[i];
//             coins[i] = coins[coins.length - 1 - i];
//             coins[coins.length - 1 - i] = temp;
//         }
// 		return solve(dp, coins, amount, 0);
//     }
// 	int solve(int[][] dp, int[] coins, int amount, int i) {
// 		if (amount == 0) return 1;
// 		if (i >= coins.length || amount < 0) return 0;
//
//         if (dp[i][amount] != -1) return dp[i][amount];
//
//         int take = 0;
//         if (amount - coins[i] >= 0) take = solve(dp, coins, amount - coins[i], i);
//         int skip = solve(dp, coins, amount, i+1);
//         dp[i][amount] = take + skip;
// 		return dp[i][amount];
// 	}
// }

// Even faster iterative
// class Solution {
//     public int change(int amount, int[] coins) {
//         int[] dp = new int[amount+1];
//         dp[0]=1;
//         for(int i:coins){
//             for(int tar=i;tar<amount+1;tar++){
//                 dp[tar]+=dp[tar-i];
//             }
//         }
//         return dp[amount];
//     }
// }

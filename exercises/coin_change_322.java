import java.util.HashMap;

// Top down solution - with memo
class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int dfs(int amount, int[] coins) {
        if (amount == 0) return 0;
        if (memo.containsKey(amount)) 
            return memo.get(amount);

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int result = dfs(amount - coin, coins);
                if (result != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + result);
                }
            }
        }

        memo.put(amount, res);
        return res;
    }

    public int coinChange(int[] coins, int amount) {
        int minCoins = dfs(amount, coins);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
}

// Top down solution - with memo but using an array as a map
// public class Solution {
//     int[] memo;
//
//     public int dfs(int amount, int[] coins) {
//         if (amount == 0) return 0;
//         if (memo[amount] != -1) 
//             return memo[amount];
//
//         int res = Integer.MAX_VALUE;
//         for (int coin : coins) {
//             if (amount - coin >= 0) {
//                 int result = dfs(amount - coin, coins);
//                 if (result != Integer.MAX_VALUE) {
//                     res = Math.min(res, 1 + result);
//                 }
//             }
//         }
//
//         memo[amount] = res;
//         return res;
//     }
//
//     public int coinChange(int[] coins, int amount) {
//         memo = new int[amount + 1];
//         Arrays.fill(memo, -1); 
//
//         int minCoins = dfs(amount, coins);
//         return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
//     }
// }


// Bottom up solution
// public class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, amount + 1);
//         dp[0] = 0;
//         for (int i = 1; i <= amount; i++) {
//             for (int j = 0; j < coins.length; j++) {
//                 if (coins[j] <= i) {
//                     dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                 }
//             }
//         }
//         return dp[amount] > amount ? -1 : dp[amount];
//     }
// }

// Top down solution - no memo
// public class Solution {
//     public int dfs(int[] coins, int amount) {
//         if (amount == 0) return 0;
//
//         int res = (int) 1e9;
//         for (int coin : coins) {
//             if (amount - coin >= 0) {
//                 res = Math.min(res, 
//                       1 + dfs(coins, amount - coin));
//             }
//         }
//         return res;
//     }
//
//     public int coinChange(int[] coins, int amount) {
//         int minCoins = dfs(coins, amount);
//         return (minCoins >= 1e9) ? -1 : minCoins;
//     }
// }

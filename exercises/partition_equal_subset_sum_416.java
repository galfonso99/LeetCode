// Top down solution (I was very close to getting this one)
class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        memo = new Boolean[n][sum / 2 + 1];
        
        return dfs(nums, 0, sum / 2);
    }

    public boolean dfs(int[] nums, int i, int target) {
        if (i == nums.length) {
            return target == 0;
        }
        if (target < 0) {
            return false;
        }
        if (memo[i][target] != null) {
            return memo[i][target];
        }

        memo[i][target] = dfs(nums, i + 1, target) || 
                          dfs(nums, i + 1, target - nums[i]);
        return memo[i][target];
    }
}

// Bottom Up solution
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) {
//             sum += num;
//         }
//         if (sum % 2 != 0) {
//             return false;
//         }
//
//         int target = sum / 2;
//         boolean[][] dp = new boolean[n + 1][target + 1];
//
//         for (int i = 0; i <= n; i++) {
//             dp[i][0] = true;
//         }
//
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= target; j++) {
//                 if (nums[i - 1] <= j) {
//                     dp[i][j] = dp[i - 1][j] || 
//                                dp[i - 1][j - nums[i - 1]];
//                 } else {
//                     dp[i][j] = dp[i - 1][j];
//                 }
//             }
//         }
//
//         return dp[n][target];
//     }
// }

// Bottom up Optimal solution
// class Solution {
//     public boolean canPartition(int[] nums) {
// 		int sum = 0;
// 		for (int i = 0; i < nums.length; i++) sum+=nums[i];
//         if (sum % 2 != 0) {
//             return false;
//         }
//         int target = sum / 2;
//         boolean[] dp = new boolean[target + 1];
//
//         dp[0] = true;
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = target; j >= nums[i]; j--) {
//                 dp[j] = dp[j] || dp[j - nums[i]];
//             }
//         }
//
//         return dp[target];
//     }
// }


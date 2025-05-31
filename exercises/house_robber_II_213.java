import java.util.Arrays;
// First working solution top-down (Absolute trash) but I was actually 95% on the money but more ugly
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
		int[] memo = new int[nums.length];
		Arrays.fill(memo, -1);
		int[] memo2 = new int[nums.length];
		Arrays.fill(memo2, -1);
		return Math.max(rec(nums, memo, 0, nums.length - 1), rec(nums, memo2, 1, nums.length));
    }
	int rec(int[] nums, int[] memo, int i, int end) {
		if (i >= end) {
			return 0;
		}
		if (memo[i] != -1) return memo[i];

		memo[i] = Math.max(rec(nums, memo, i+1, end),
					nums[i] + rec(nums, memo, i+2, end));
		return memo[i];
	}
}

// Bottom-up
// class Solution {
//     public int rob(int[] nums) {
//         if (nums.length == 1) return nums[0];
//         return Math.max(helper(nums, nums.length - 1),
//                         helper(nums, nums.length));
//     }
//
//     private int helper(int[] nums, int end) {
//         if (end == 0) return 0;
//         if (end == 1) return nums[0];
//
//         int[] dp = new int[end];
//         dp[0] = end == nums.length ? 0 : nums[0];
//         dp[1] = Math.max(dp[0], nums[1]);
//
//         for (int i = 2; i < end; i++) {
//             dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
//         }
//
//         return dp[end - 1];
//     }
// }

// Cleaned up top-down solution (this one is in some ways more elegant but in others more ugly)
// public class Solution {
//     private int[][] memo;
//
//     public int rob(int[] nums) {
//         if (nums.length == 1) return nums[0];
//
//         memo = new int[nums.length][2];
//         for (int i = 0; i < nums.length; i++) {
//             memo[i][0] = -1;
//             memo[i][1] = -1;
//         }
//
//         return Math.max(dfs(0, 1, nums), dfs(1, 0, nums));
//     }
//
//     private int dfs(int i, int flag, int[] nums) {
//         if (i >= nums.length || (flag == 1 && i == nums.length - 1)) 
//             return 0;
//         if (memo[i][flag] != -1)
//             return memo[i][flag];
//         memo[i][flag] = Math.max(dfs(i + 1, flag, nums), 
//                         nums[i] + dfs(i + 2, flag, nums));
//         return memo[i][flag];
//     }
// }


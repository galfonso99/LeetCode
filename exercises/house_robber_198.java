// top down approach
class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        for (int i = 0; i < memo.length; i++) memo[i] = -1;
        return rec(nums, memo, 0);
    }

    int rec(int[] nums, int[] memo, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.max(nums[i] + rec(nums, memo, i+2), rec(nums, memo, i+1));
        return memo[i];
    }
}

// Bottom up approach
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[nums.length - 1];
    }
}

import java.util.Arrays;
import java.util.HashMap;

// Top down approach but with Arrays instead of HashMaps (Maps are reaaallly slow)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;
		for (int num : nums) sum += num;
		int[][] dp = new int[nums.length][2*sum+1];
		for (int[] row : dp) Arrays.fill(row, -1);
		return solve(nums, dp, 0, target, sum);
    }
	int solve(int[] nums, int[][] dp, int i, int target, int sum) {
		if (i == nums.length && target == 0) return 1;
		if (i >= nums.length) return 0;

		int targetIndex = target+sum;
		if (targetIndex < 0 || targetIndex >= dp[0].length) return 0;

		if (dp[i][targetIndex] != -1) return dp[i][targetIndex];

		int plus = solve(nums, dp, i+1, target - nums[i], sum);
		int minus = solve(nums, dp, i+1, target + nums[i], sum);
		dp[i][targetIndex] = plus + minus;
		return dp[i][targetIndex];
	}
}

// Iterative Solution
// public class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) { sum += num; }
//         if (target > sum || target < -sum) { return 0; }
//         int[][] dp = new int[n + 1][2 * sum + 1];
//
//         dp[0][sum] = 1; 
//
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= 2 * sum; j++) {
//                 if (dp[i][j] > 0) { 
//                     int currentSum = j - sum; // Co
//                     int newSum1 = currentSum + nums[i];
//                     int newIndex1 = newSum1 + sum; // Convert to offset index
//                     if (newIndex1 >= 0 && newIndex1 <= 2 * sum) {
//                         dp[i + 1][newIndex1] += dp[i][j];
//                     }
//
//                     int newSum2 = currentSum - nums[i];
//                     int newIndex2 = newSum2 + sum; // Convert to offset index
//                     if (newIndex2 >= 0 && newIndex2 <= 2 * sum) {
//                         dp[i + 1][newIndex2] += dp[i][j];
//                     }
//                 }
//             }
//         }
//         int targetIndex = target + sum;
//         return dp[n][targetIndex];
//     }
// }


// Original working solution
// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
// 		HashMap<Integer, HashMap<Integer, Integer>> hm = new HashMap<>();
// 		return solve(nums, hm, 0, target);
//     }
// 	int solve(int[] nums, HashMap<Integer, HashMap<Integer, Integer>> hm, int i, int target) {
// 		if (i == nums.length && target == 0) return 1;
// 		if (i >= nums.length) return 0;
//
// 		if (hm.containsKey(target) && hm.get(target).containsKey(i)) return hm.get(target).get(i);
//
// 		int plus = solve(nums, hm, i+1, target - nums[i]);
// 		int minus = solve(nums, hm, i+1, target + nums[i]);
// 		if (!hm.containsKey(target)) { hm.put(target, new HashMap<>()); }
// 		hm.get(target).put(i, plus + minus);
// 		return plus + minus;
// 	}
// }


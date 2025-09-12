import java.util.Arrays;

// Greedy Approach (Within a certain window find the farthest you can you in one jump)
class Solution {
    public int jump(int[] nums) {
        int res = 0, l = 0, r = 0;

        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res++;
        }
        return res;
    }
}

// Dynamic Programming Approach (Not what the problem wanted)
// class Solution {
//     public int jump(int[] nums) {
// 		int[] dp = new int[nums.length];
// 		Arrays.fill(dp, Integer.MAX_VALUE - 10000);
// 		dp[nums.length - 1] = 0;
// 		for (int i = nums.length - 2; i >= 0; i--) {
// 			int j = i + nums[i] > nums.length - 1 ? nums.length - 1 : i + nums[i];
// 			for (; j >= i + 1; j--) {
// 				dp[i] = Math.min(dp[j] + 1, dp[i]);
// 			}
// 		}
// 		return dp[0];
//     }
// }


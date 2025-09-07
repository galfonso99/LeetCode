// Solve using greedy algorithm
// At each local state make the most optimal solution and hope that it adds up to the global optimal solution
// It works in this case
// So at each state keep the running total if its bigger than zero otherwise reset to zero
// Original passing solution (O(n)) Kadane's Algorithm Apparently 
class Solution {
    public int maxSubArray(int[] nums) {
		int running_total = 0;
		int largest_sum = nums[0];

		for (int val : nums) {
			running_total += val;
			running_total = Math.max(running_total, 0);
			largest_sum = Math.max(running_total, largest_sum);
		}
		return largest_sum;
    }
}


// Divide and conquer Solution
// class Solution {
//     public int maxSubArray(int[] nums) {
//         return dfs(nums, 0, nums.length - 1);
//     }
//
//     private int dfs(int[] nums, int l, int r) {
//         if (l > r) { return Integer.MIN_VALUE; }
//         int m = (l + r) >> 1;
//         int leftSum = 0, rightSum = 0, curSum = 0;
//         for (int i = m - 1; i >= l; i--) {
//             curSum += nums[i];
//             leftSum = Math.max(leftSum, curSum);
//         }
//         curSum = 0;
//         for (int i = m + 1; i <= r; i++) {
//             curSum += nums[i];
//             rightSum = Math.max(rightSum, curSum);
//         }
//
//         return Math.max(dfs(nums, l, m - 1),
//                         Math.max(dfs(nums, m + 1, r),
//                              leftSum + nums[m] + rightSum));
//     }
// }


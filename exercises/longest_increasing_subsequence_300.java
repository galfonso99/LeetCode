import java.util.Arrays;
// Original solution
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
		int max = memo[0];
		for (int i = 1; i < memo.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                } 
            }
			max = Math.max(memo[i], max);
		}
		return max;
    }
}

// More optimized Solution ( O(nlogn) )
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         List<Integer> dp = new ArrayList<>();
//         dp.add(nums[0]);
//         int LIS = 1;
//         for (int i = 1; i < nums.length; i++) {
//             if (dp.get(dp.size() - 1) < nums[i]) { 
//                 dp.add(nums[i]);
//                 LIS++;
//                 continue;
//             }
//             int idx = Collections.binarySearch(dp, nums[i]);
//             if (idx < 0) idx = -idx - 1; 
//             dp.set(idx, nums[i]); 
//         }
//         return LIS;
//     }
// }

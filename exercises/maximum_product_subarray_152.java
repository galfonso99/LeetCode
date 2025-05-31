// How I was supposed to solve it (by realizing the problem and the subproblems 
// and how negative numbers would break the recursive solution and so trying to 
// solve it by keeping a dp table for minimum as well)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        
        int result = nums[0];
        
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(nums[i], 
                       Math.max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]));
            dpMin[i] = Math.min(nums[i], 
                       Math.min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]));
            
            result = Math.max(result, dpMax[i]);
        }
        
        return result;
    }
}

// Space optimized alternative to the above (Kadane's Algorithm)
// class Solution {
//     public int maxProduct(int[] nums) {
//         int res = nums[0];
//         int curMin = 1, curMax = 1;
//
//         for (int num : nums) {
//             int tmp = curMax * num;
//             curMax = Math.max(Math.max(num * curMax, num * curMin), num);
//             curMin = Math.min(Math.min(tmp, num * curMin), num);
//             res = Math.max(res, curMax);
//         }
//         return res;
//     }
// }

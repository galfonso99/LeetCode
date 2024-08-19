import static java.lang.System.out;
// import java.util.*;

public class twoSumII167 {
    public static void main(String[] args) {
        var sol = new Solution();
        var res = sol.twoSum(new int[] {-1, 0}, -1);
        out.printf("The result is index1: %d, index2: %d %n", res[0], res[1]);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (true) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                return new int[] {l+1, r+1};
            }
        }
    }
}


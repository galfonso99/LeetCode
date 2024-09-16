
public class binarySearch704 {
    public static void main(String[] args) {
        // var sol = new Solution();
        // var res = sol.search(new int[] {1,2,3,4,5,6}, 4);
        // out.printf("The result is %d %n", res);
    }
}

class Solution_704 {
    public int search(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target);
    }
    int bs (int[] nums, int lo, int hi, int target) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] < target) {
            return bs(nums, lo, mid - 1, target);
        } else if (nums[mid] > target) {
            return bs(nums, mid + 1, hi, target);
        } else {
            return mid;
        }
    }
}

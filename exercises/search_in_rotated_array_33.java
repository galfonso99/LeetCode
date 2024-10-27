// Original answer
class Solution {
	public int search(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			var mid = (l + r) / 2;
			var midVal = nums[mid];
			var endVal = nums[r];
			var startVal = nums[l];
			if (nums[mid] > target) {
				if (endVal < midVal && endVal >= target && startVal > target) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			} else if (midVal < target) {
				if (endVal > midVal && endVal < target && startVal <= target) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				return mid;
			}
		}
		return -1;
	}
}

// Better Solution
//public class Solution {
//    public int search(int[] A, int target) {
//        int lo = 0;
//        int hi = A.length - 1;
//        while (lo <= hi) {
//            int mid = (lo + hi) / 2;
//            if (A[mid] == target)
//                return mid;
//
//            if (A[lo] <= A[mid]) {
//                if (target >= A[lo] && target < A[mid]) {
//                    hi = mid - 1;
//                } else {
//                    lo = mid + 1;
//                }
//            } else {
//                if (target > A[mid] && target <= A[hi]) {
//                    lo = mid + 1;
//                } else {
//                    hi = mid - 1;
//                }
//            }
//        }
//        return -1;
//    }
//}

// Shorter but more complex answer
//class Solution {
//	public int search(int[] nums, int target) {
//		int l = 0;
//		int r = nums.length - 1;
//		while (l <= r) {
//			var mid = (l + r) / 2;
//			var midVal = nums[mid];
//			var endVal = nums[r];
//			var startVal = nums[l];
//			if ((midVal > target && endVal < midVal && endVal >= target && startVal > target) 
//			|| (midVal < target && !(endVal > midVal && endVal < target && startVal <= target))) {
//				l = mid + 1;
//			} else if ((midVal < target && endVal > midVal && endVal < target && startVal <= target)
//			|| (midVal > target && !(endVal < midVal && endVal >= target && startVal > target))) {
//				r = mid - 1;
//			} else {
//				return mid;
//			}
//		}
//		return -1;
//	}
//}


//33. Search in Rotated Sorted Array
//
//There is an integer array nums sorted in ascending order (with distinct values).
//
//Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//
//You must write an algorithm with O(log n) runtime complexity.
//
//
//
//Example 1:
//
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//
//Example 2:
//
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
//
//Example 3:
//
//Input: nums = [1], target = 0
//Output: -1
//
//
//
//Constraints:
//
//    1 <= nums.length <= 5000
//    -104 <= nums[i] <= 104
//    All values of nums are unique.
//    nums is an ascending array that is possibly rotated.
//    -104 <= target <= 104
//
//

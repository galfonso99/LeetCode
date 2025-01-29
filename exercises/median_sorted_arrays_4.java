// If arr1 is bigger swap it and make arr1 smaller than arr2
// while left is less than or equal to right find the partition for arr1 and the
// partition for arr2
// Then find the maximum of the left side of arr1, the minimum of the right side
// of arr1 the max of the left side of arr2 and the min of the right side of arr2
// Using max1, min1, max2, min2 check if we found the right partition and calculate
// the median then and there
// Otherwise if max1 bigger than min2 then adjust the upper bound of the search window,
// because the partition must be to the left
// Else if max2 is bigger than min1 adjust the lower bound bc it must be to the right

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int n = nums1.length;
        int m = nums2.length;
        int half = (n + m + 1) / 2;
        int left = 0;
        int right = n;
        
        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = half - partition1;
            
            // Get left and right elements for both arrays
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == n) ? Integer.MAX_VALUE : nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == m) ? Integer.MAX_VALUE : nums2[partition2];
            
            // Check if we found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If total length is even
                if ((n + m) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
                // If total length is odd
                else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            }
            // Adjust the partition
            else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            }
            else {
                left = partition1 + 1;
            }
        }
        
        // Should never reach here if arrays are sorted
        return -1;
    }
}

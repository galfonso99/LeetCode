package main

import "core:fmt"

main :: proc() {
	arr1 := []int{1,3}
	arr2 := []int{2}
	count := find_median_sorted_arrays(arr1, arr2)
	fmt.println(count)
}

find_median_sorted_arrays :: proc(arr1: []int, arr2: []int) -> f64 {
	nums1 := arr1
	nums2 := arr2
    if len(nums1) > len(nums2) {
        nums1, nums2 = nums2, nums1
    }

    n := len(nums1)
    m := len(nums2)
    half := (n + m + 1) / 2

    lo := 0
    hi := n

    for lo <= hi {
        partition1 := (lo + hi) / 2
        partition2 := half - partition1

        maxLeft1 := partition1 == 0 ? min(int) : nums1[partition1 - 1]
        minRight1 := partition1 == n ? max(int) : nums1[partition1]

        maxLeft2 := partition2 == 0 ? min(int) : nums2[partition2 - 1]
        minRight2 := partition2 == m ? max(int) : nums2[partition2]

        if maxLeft1 <= minRight2 && maxLeft2 <= minRight1 {
            if (n + m) % 2 == 0 {
                return (f64(max(maxLeft1, maxLeft2)) + f64(min(minRight1, minRight2))) / 2
            } else {
                return f64(max(maxLeft1, maxLeft2))
            }
        } else if maxLeft1 > minRight2 {
            hi = partition1 - 1
        } else {
            lo = partition1 + 1
        }
    }

    return -1
}

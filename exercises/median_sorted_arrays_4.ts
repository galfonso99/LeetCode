function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
	if (nums1.length > nums2.length) {
		[nums1, nums2] = [nums2, nums1];
	}

	const n = nums1.length;
	const m = nums2.length;
	const half = Math.floor((n + m + 1) / 2);
	let left = 0;
	let right = n;

	while (left <= right) {
		const partition1 = Math.floor((left + right) / 2);
		const partition2 = half - partition1;

		const maxLeft1 = partition1 === 0 ? Number.MIN_SAFE_INTEGER : nums1[partition1 - 1];
		const minRight1 = partition1 === n ? Number.MAX_SAFE_INTEGER : nums1[partition1];

		const maxLeft2 = partition2 === 0 ? Number.MIN_SAFE_INTEGER : nums2[partition2 - 1];
		const minRight2 = partition2 === m ? Number.MAX_SAFE_INTEGER : nums2[partition2];

		if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
			if ((n + m) % 2 === 0) {
				return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
			} else {
				return Math.max(maxLeft1, maxLeft2);
			}
		} else if (maxLeft1 > minRight2) {
			right = partition1 - 1;
		} else {
			left = partition1 + 1;
		}
	}

	return -1;
}

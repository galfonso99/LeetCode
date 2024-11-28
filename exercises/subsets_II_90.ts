function subsetsWithDup(nums: number[]): number[][] {
	const subsets: number[][] = []
	nums.sort((a,b) => a - b)

	function recurse(subset: number[], start: number) {
		subsets.push([...subset])
		for (let i = start; i < nums.length; i++) {
			if (i != start && nums[i] == nums[i-1]) continue
			subset.push(nums[i])
			recurse(subset, i + 1)
			subset.pop()
		}
	}

	recurse([], 0)
	return subsets
};


function combinationSum2(nums: number[], target: number): number[][] {
	const combs: number[][] = []
	nums.sort()

	function recurse(comb: number[], t: number, start: number) {
		if (t == 0) combs.push([...comb]) 
		for (let i = start; i < nums.length; i++) {
			if (i != start && nums[i] == nums[i-1]) continue
			if (t - nums[i] < 0) continue
			comb.push(nums[i])
			recurse(comb, t - nums[i], i + 1)
			comb.pop()
		}
	}

	recurse([], target, 0)
	return combs
};

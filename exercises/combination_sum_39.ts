function combinationSum(candidates: number[], target: number): number[][] {
	const combs: number[][] = []

	function recurse(comb: number[], target: number, start: number) {
		if (target == 0) combs.push([...comb])
		for (let i = start; i < candidates.length; i++) {
			if (target - candidates[i] >= 0) {
				comb.push(candidates[i])
				recurse(comb, target - candidates[i], i)
				comb.pop()
			}
		}
	}

	recurse([], target, 0)
	return combs
};

combinationSum([1,2,3,4,5], 5)

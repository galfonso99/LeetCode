function permute(nums: number[]): number[][] {
	const perms: number[][] = []
	const visited: boolean[] = new Array(nums.length)

	function recurse(perm: number[], visited: boolean[]) {
		if (perm.length == nums.length) perms.push([...perm])
		for (let i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				perm.push(nums[i])
				visited[i] = true
				recurse(perm, visited)
				visited[i] = false
				perm.pop()
			}
		}
	}

	recurse([], visited)
	return perms
};


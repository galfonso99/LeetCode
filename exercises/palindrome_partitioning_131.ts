function partition(s: string): string[][] {
	const len = s.length
	const res: string[][] = []
    const dp = [...Array(len)].map(() => Array(len).fill(false))
	for (let i = 0; i < s.length; i++) {
		for (let j = 0; j < s.length; j++) {
			dp[j][i] = (s[j] == s[i] && (i - j <= 2 || dp[j+1][i-1]));
		}
	}
	recurse([], 0)
	return res

	function recurse(path: string[], pos: number) {
		if (pos == len) res.push([...path])
		for (let i = pos; i < len; i++) {
			if (dp[pos][i]) {
				path.push(s.substring(pos, i+1))
				recurse(path, i+1)
				path.pop()
			}
		}
	}
};


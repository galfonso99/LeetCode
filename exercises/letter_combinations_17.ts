function letterCombinations(digits: string): string[] {
    if (digits.length == 0) return []
	const res: string[] = []
	const arr: any = [["2", "abc"], ["3", "def"], ["4", "ghi"], ["5", "jkl"], ["6", "mno"], ["7", "pqrs"], ["8", "tuv"], ["9", "wxyz"]]
	const map: Map<string, string> = new Map(arr)
	recurse("", 0)
	return res

	function recurse(substring: string, index: number) {
		if (index == digits.length) {
            res.push(String(substring))
            return
        }
        let candidates: string = map.get(digits[index])
		for (let i = 0; i < candidates.length; i++) {
            const ch = candidates[i]
			substring = substring.concat(ch)
			recurse(substring, index+1)
			substring = substring.slice(0, -1)
		}
	}
};


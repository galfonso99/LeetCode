// Sol with nested functions
function subsets(nums: number[]): number[][] {
    const subsets: number[][] = [];

    function recurse(subset: number[], start: number) {
        const new_subset = [...subset];
        subsets.push(new_subset);
        
        for (let i = start; i < nums.length; i++) {
            subset.push(nums[i]);
            recurse(subset, i + 1);
            subset.pop();
        }
    }

    recurse([], 0);
    return subsets;
}
subsets([1,2,3,4,5])

// Original Solution without nested functions
//function subsets(nums: number[]): number[][] {
//	const subsets: number[][] = []
//	recurse(nums, subsets, [], 0)
//	return subsets
//};
//function recurse(nums: number[], subsets: number[][], subset: number[], start: number) {
//    let new_subset = [...subset]
//	subsets.push(new_subset)
//	for (let i = start; i < nums.length; i++) {
//		subset.push(nums[i])
//		recurse(nums, subsets, subset, i+1)
//		subset.pop()
//	}
//}


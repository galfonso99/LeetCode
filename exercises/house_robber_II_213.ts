function rob(nums: number[]): number {
    if (nums.length === 1) return nums[0];
    const memo1 = new Array(nums.length).fill(-1);
    const memo2 = new Array(nums.length).fill(-1);
    return Math.max(robHelper(nums, memo1, 0, nums.length - 1),
					robHelper(nums, memo2, 1, nums.length));
}

function robHelper(nums: number[], memo: number[], start: number, end: number): number {
    if (start >= end) return 0;
    if (memo[start] !== -1) return memo[start];
    memo[start] = Math.max(robHelper(nums, memo, start + 1, end),
					nums[start] + robHelper(nums, memo, start + 2, end));
    return memo[start];
}

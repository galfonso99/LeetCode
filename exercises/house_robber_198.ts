function rob(nums: number[]): number {
  const memo: number[] = new Array(nums.length).fill(-1);
  return rec(nums, memo, 0);
}

function rec(nums: number[], memo: number[], i: number): number {
  if (i >= nums.length) {
    return 0;
  }
  if (memo[i] !== -1) {
    return memo[i];
  }
  memo[i] = Math.max(nums[i] + rec(nums, memo, i + 2), rec(nums, memo, i + 1));
  return memo[i];
}

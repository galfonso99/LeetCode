/*
 * @lc app=leetcode id=169 lang=rust
 *
 * [169] Majority Element
 */

// @lc code=start
impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        let mut el = nums[0];
        let mut count = 1;
        for i in 1..nums.len() {
            if count == 0 { el = nums[i]; }
            count += if el == nums[i] { 1 } else { -1 };
        }
        el
    }
}
// @lc code=end

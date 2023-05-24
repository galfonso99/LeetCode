/*
 * @lc app=leetcode id=136 lang=rust
 *
 * [136] Single Number
 */

// @lc code=start
impl Solution {
    pub fn single_number(mut nums: Vec<i32>) -> i32 {
        nums.into_iter().reduce( |acc, x| acc ^ x).unwrap()
    }
}
// @lc code=end

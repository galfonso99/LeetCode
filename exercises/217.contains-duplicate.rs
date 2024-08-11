/*
 * @lc app=leetcode id=217 lang=rust
 *
 * [217] Contains Duplicate
 */

// @lc code=start
impl Solution {
    pub fn contains_duplicate(nums: Vec<i32>) -> bool {
        let mut set = std::collections::HashSet::new();
        nums.iter().any(|val| !set.insert(val))
    }
}
// @lc code=end

// Create a HashSet
// Loop vec and insert valP
// if fails returns false
// else return true
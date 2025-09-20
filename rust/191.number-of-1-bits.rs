/*
 * @lc app=leetcode id=191 lang=rust
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
impl Solution {
    pub fn hammingWeight (n: u32) -> i32 {
        n.count_ones() as i32
    }
}
// @lc code=end


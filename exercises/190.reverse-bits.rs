/*
 * @lc app=leetcode id=190 lang=rust
 *
 * [190] Reverse Bits
 */

// @lc code=start
impl Solution {
    pub fn reverse_bits(mut x: u32) -> u32 {
        let mut res = 0;
        for _ in 0..32 {
            res = (res << 1) | (x & 1);
            x >>= 1;
        }
        res
    }
}
// @lc code=end


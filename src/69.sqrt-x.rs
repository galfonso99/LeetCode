/*
 * @lc app=leetcode id=69 lang=rust
 *
 * [69] Sqrt(x)
 */

// @lc code=start
impl Solution {
    // Newton Algorithm
    pub fn my_sqrt(x: i32) -> i32 {
        if x == 0 { return 0; }
        let x = x as i64;   //Guard for overflow
        let mut mid = x;
        while mid > x/mid{
            mid = (x / mid + mid) / 2;
        }
        mid as i32
    }
}
// @lc code=end
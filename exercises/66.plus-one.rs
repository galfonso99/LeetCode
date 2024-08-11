/*
 * @lc app=leetcode id=66 lang=rust
 *
 * [66] Plus One
 */

// @lc code=start
impl Solution {
    pub fn plus_one(mut digits: Vec<i32>) -> Vec<i32> {
        for x in digits.iter_mut().rev() {
            if x == &9 {
                *x = 0
            }
            else {
                *x += 1;
                return digits;
            }
        }
        digits.insert(0, 1);
        digits
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=125 lang=rust
 *
 * [125] Valid Palindrome
 */

// @lc code=start
impl Solution {
    pub fn is_palindrome(mut s: String) -> bool {
        s.retain(|c| c.is_alphanumeric());
        s = s.to_lowercase();
        s.chars().take(s.len()/2).eq(s.chars().rev().take(s.len()/2))
    }
}
// @lc code=end

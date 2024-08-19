/*
 * @lc app=leetcode id=28 lang=rust
 *
 * [28] Find the Index of the First Occurrence in a String
 */

// @lc code=start
impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        let (n_len, h_len) = (needle.len(), haystack.len());
        if n_len > h_len { return -1; }
        for index in 0..(h_len - n_len + 1) {
            if haystack[index..(index+n_len)] == needle {
                return index as i32;
            }
        }
        -1
    }
}
// @lc code=end

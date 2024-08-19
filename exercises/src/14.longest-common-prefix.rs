/*
 * @lc app=leetcode id=14 lang=rust
 *
 * [14] Longest Common Prefix
 */
mod longest;

struct Solution {

}

// @lc code=start
impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        strs.into_iter().reduce(|acc, st| acc.chars().zip(st.chars())
        .take_while(|(x,y)| x == y)
        .map(|e| e.0)
        .collect()
    ).unwrap_or("".to_string())
    }
}
// @lc code=end

pub fn main() {
    Solution::longest_common_prefix("ass".to_string());
}

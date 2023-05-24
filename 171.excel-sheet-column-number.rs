/*
 * @lc app=leetcode id=171 lang=rust
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
impl Solution {
    pub fn title_to_number(column_title: String) -> i32 {
        let toCapital = b'A'; 
        column_title.chars().map(|c| c as u8 - toCapital).rev().enumerate()
                    .reduce(|acc, (idx, num)| (idx, acc.1 + num * (idx as u8 + 1))).unwrap().1 as i32
    
    }
}
// @lc code=end


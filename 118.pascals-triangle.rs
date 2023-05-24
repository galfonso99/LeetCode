/*
 * @lc app=leetcode id=118 lang=rust
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
impl Solution {
  pub fn generate(num_rows: i32) -> Vec<Vec<i32>> {
    let mut cur = vec![vec![1i32]];
    for row in 1..num_rows {
        let mut new_row: Vec<i32> = cur.last().unwrap().windows(2).map(|x| x[0] + x[1]).collect();
        cur.push([&[1], new_row.as_slice(), &[1]].concat());
    }
    cur
}
}
// @lc code=end

/*
 * @lc app=leetcode id=121 lang=rust
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let (mut profit, mut buy) = (0, prices[0]);
        for i in 1..prices.len() {
            profit = i32::max(profit, prices[i] - buy);
            buy = i32::min(buy, prices[i]);
        }
        profit
    }
    
}
// @lc code=end


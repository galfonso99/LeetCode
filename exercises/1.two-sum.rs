/*
 * @lc app=leetcode id=1 lang=rust
 *
 * [1] Two Sum
 */

// @lc code=start
impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        use std::collections::HashMap;
        let mut map = HashMap::new();
        let mut arr: Vec<i32> = Vec::new();
        nums.iter().enumerate().for_each(|(i, val)| {map.insert(target - val, i);});
        for (i, x) in nums.iter().enumerate() {
            if map.contains_key(x) && *map.get(&x).unwrap_or(&0) != i {
                arr = vec![i as i32, *map.get(x).unwrap_or(&0) as i32];
                return arr;
            }
        }
        arr
    }
}
// @lc code=end


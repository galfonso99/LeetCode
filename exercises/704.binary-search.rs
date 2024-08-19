use Solution

impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        // Find the middle, if lower continue with upper half only, if higher continue with lower
        // half only, if equal you found it
        use std::cmp::Ordering;
        let (mut left, mut right) = (0, nums.len() - 1);
        while left <= right {
            let middle = (right - left) / 2 + left;
            match nums[middle].cmp(&target) {
                Ordering::Less => left = middle + 1,
                Ordering::Greater => right = middle - 1,
                Ordering::Equal => return middle as i32,
            }; 
        }
        return -1;
    }
}



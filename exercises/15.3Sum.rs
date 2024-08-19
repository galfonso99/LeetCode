impl Solution {
    pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {
        use std::{cmp::Ordering, collections::HashSet};
        let mut sorted_nums = nums.clone();
        let mut result: HashSet<Vec<i32>> = HashSet::new();
        sorted_nums.sort();
        for i in 0..sorted_nums.len() {
            let target = sorted_nums[i] * -1;
            let mut begin = i + 1;
            let mut end = sorted_nums.len() - 1;
            while begin < end {
                let sum = sorted_nums[begin] + sorted_nums[end];
                match sum.cmp(&target) {
                    Ordering::Equal => {
                        result.insert(vec![sorted_nums[i], sorted_nums[begin], sorted_nums[end]]);
                        end -= 1;
                    }
                    Ordering::Greater => {
                        end -= 1;
                    }
                    Ordering::Less => {
                        begin += 1;
                    }
                }
            }
        }
        result.into_iter().collect()
    }
}


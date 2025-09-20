pub fn missing_number(nums: Vec<i32>) -> i32 {
        let len = nums.len() as i32;
        nums.into_iter().enumerate().fold(len, |acc, (ind, num)| {
            acc ^ num ^ ind as i32
        })
    }

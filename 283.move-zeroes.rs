    pub fn move_zeroes(nums: &mut Vec<i32>) {
        let mut first_zero = None;
        for i in 0..nums.len() {
            let val = nums[i];
            if val == 0 && first_zero.is_none() {
                first_zero = Some(i);
            }
            if val != 0 && first_zero.is_some() {
                let zero = first_zero.unwrap();
                nums.swap(i, zero);
                first_zero = if nums[zero+1] == 0 {Some(zero+1)} else {None};
            }
        }
    }

// pub fn move_zeroes(nums: &mut Vec<i32>) {
//         let mut last_non_zero = 0;

//         for i in 0..nums.len() {
//             if nums[i] != 0 {
//                 if i != last_non_zero {
//                     nums.swap(i, last_non_zero);
//                 }
//                 last_non_zero += 1;
//             }
//         }

//     }

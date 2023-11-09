
pub fn three_sum(mut nums: Vec<i32>) -> Vec<Vec<i32>> {
    let mut result = vec![];
    for i in 0..nums.len() {
        let mut hm = HashMap::new();
        nums.iter().enumerate().skip(i+1).for_each(|(j,x)| {hm.insert(nums[i] * -1 - x, j);});
        for (j, x) in nums.iter().enumerate().skip(i+1){
            if hm.contains_key(x) && *hm.get(&x).unwrap_or(&0) != j {
                let k = *hm.get(&x).unwrap_or(&0);
                result.push(vec![nums[i], nums[j], nums[k]]);
            }
        }

    }
    result
}


pub fn three_sum(mut nums: Vec<i32>) -> Vec<Vec<i32>> {
    nums.sort();
    let (mut prev1, mut prev2, mut prev3) = (i32::MIN, i32::MIN, i32::MIN);
    let mut result = vec![];
    for i in 0..nums.len() {
        if nums[i] > 0 {break;}
        if nums[i] == prev1 { continue; }
        for j in i+1..nums.len() {
            if nums[j] == prev2 { continue; }
            if nums[i] + nums[j] >= 0 && nums[j] > 0 {break;}
            for k in (j+1..nums.len()).rev() {
                // println!("{:?} {}", vec![nums[i], nums[j], nums[k]], nums[k] == prev3);
                if nums[k] == prev3 {continue;}
                if nums[i] + nums[j] + nums[k] == 0 {
                    result.push(vec![nums[i], nums[j], nums[k]]);
                    break;
                }
                prev3 = nums[k];
            }
            prev2 = nums[j];
            prev3 = i32::MIN;
        }
        prev1 = nums[i];
        prev2 = i32::MIN;
        prev3 = i32::MIN;
    }
    result
}




    // pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {
    //     // Sort it
    //     // do 3 nested loops
    //     // if ever val > 0 then break
    //     // if the sum equals 0 then sort the triplet [a, b, c] and insert into hashset
    //     use std::collections::HashMap;
    //     use std::collections::HashSet;
    //     let mut map: HashMap<i32, Vec<(usize, usize)>> = HashMap::new();
    //     let mut set = HashSet::new();
    //     // let mut result = vec![];
    //    for i in 0..nums.len() {
    //        for j in i+1..nums.len() {
    //            let sum = nums[i] + nums[j];
    //            map.entry(sum).and_modify(|arr| arr.push((i, j))).or_insert(vec![(i,j)]);
    //        }
    //    }
    // //    println!("{:?}", map);
    //    for i in 0..nums.len() {
    //        let val = nums[i];
    //        if let Some(arr) = map.get(&(val * -1)) {
    //         //    println!("{:?}", arr);
    //            for &(j, k) in arr {
    //                if i != j && i != k {
    //                    let mut triplet = vec![nums[i], nums[j], nums[k]];
    //                    triplet.sort();
    //                    set.insert(triplet);
    //                }
    //            }
    //        }
    //    }
    //    set.into_iter().collect()
    // }

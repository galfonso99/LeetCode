/*
 * @lc app=leetcode id=26 lang=rust
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        let mut curr = 1;
        for i in 1..nums.len() {
            if nums[i] > nums[curr-1] {
                nums[curr] = nums[i];
                curr += 1;
            }
        }
        curr as i32
    }
}
// @lc code=end

// while length of arr
//    while ele <= arr[curr - 1]
//        i+=1
//    arr[curr] = arr[i]
//    curr = i
// [0,0,1,1,1,2,2,3,3,4]


// pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
//     let mut i = 1;
//     let mut curr = 1;
//     while i < nums.len() {
//         while nums[i] <= nums[curr-1] {
//             i+=1;
//         }
//         nums[curr] = nums[i];
//         curr = i;
//     }
//     nums.len() as i32
// }
struct Solution;
fn main() {}

impl Solution {
    pub fn first_uniq_char(s: String) -> i32 {
        let mut chars = [0; 27];
        for c in s.chars() {
            let index = c as u8 - 64;
            chars[index as usize] += 1;
        }
        for (i,c) in s.chars().enumerate() {
            let index = c as u8 - 64;
            if chars[index as usize] == 1 {
                return i as i32;
            }
        }
        0
    }
}
// Precompute the input into an array where the chars are the index and the count is the value
// Then in another loop for each value of S check if the count is higher than zero, and if not you've found
// The unique value 


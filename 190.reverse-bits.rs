/*
 * @lc app=leetcode id=190 lang=rust
 *
 * [190] Reverse Bits
 */

// @lc code=start
impl Solution {
    pub fn reverse_bits(x: u32) -> u32 {
        let bit_string = x.to_be_bytes().iter().map(|b| {
            let mut byte = *b;
            let mut str = String::new();
            for i in 0..=7 {
                let sig_bit = 2u8.pow(7-i);
                if sig_bit > byte {
                    str.push('0');
                } 
                else {
                    byte -= sig_bit;
                    str.push('1');
                }
            }
            str
        }).collect::<String>().chars().rev().collect::<String>();
        u32::from_str_radix(&bit_string, 2).unwrap_or(0)
    }
}
// @lc code=end


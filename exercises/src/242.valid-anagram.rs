/*
 * @lc app=leetcode id=242 lang=rust
 *
 * [242] Valid Anagram
 */

// @lc code=start
impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        if s.len() != t.len() {
            return false;
        }
        let mut s_count: Vec<i32> = vec![0; 27];
        let mut t_count: Vec<i32> = vec![0; 27];
        for i in 0..s.len() {
            let s_ascii_to_int = (s[i..i + 1].chars().next().unwrap()) as u32 - 97;
            let t_ascii_to_int = (t[i..i + 1].chars().next().unwrap()) as u32 - 97;
            s_count[s_ascii_to_int as usize] += 1;
            t_count[t_ascii_to_int as usize] += 1;
        }
        for i in 0..27 {
            if s_count[i] != t_count[i] {
                return false;
            }
        }
        true
    }
}
// @lc code=end

/* Other solution by someone else
    pub fn is_anagram(s: String, t: String) -> bool {
       let mut map = std::collections::HashMap::new();
       s.chars().for_each(|c| *map.entry(c).or_insert(0) += 1);
       t.chars().for_each(|c| *map.entry(c).or_insert(0) -= 1);
       map.into_values().all(|v| v == 0)
   }
*/
//  Other solution 
//     pub fn is_anagram(s: String, t: String) -> bool {
//        let mut array = [0_usize; 27];
//        s.chars().for_each(|c| array[(c as u32 - 97) as usize] += 1);
//        t.chars().for_each(|c| array[(c as u32 - 97) as usize] -= 1);
//        array.into_values().all(|v| v == 0)
//    }


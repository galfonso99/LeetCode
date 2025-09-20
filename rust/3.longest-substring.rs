    pub fn length_of_longest_substring(s: String) -> i32 {
        let mut chars = [std::usize::MAX; 127];
        let mut longest = 0;
        let mut start = 0_usize;
        for (i,c) in s.char_indices() {
            let char_ind = c as usize;
            if chars[char_ind] >= start && chars[char_ind] < i {
                start = chars[char_ind] + 1;
            }
            chars[char_ind] = i;
            let length = i - start + 1;
            if length > longest { longest = length }
        }
        longest as i32
    }

// pub fn length_of_longest_substring(s: String) -> i32 {
//     // use std::collections::VecDeque;
//     let mut longest = 0;
//     let mut substr = String::new();
//     for chr in s.chars() {
//         if substr.contains(chr) {
//             // while Some(chr) != substr.pop_front() { };
//             substr = substr.chars().skip_while(|x| x != &chr).skip(1).collect();
//         }
//         substr.push(chr);
//         if substr.len() > longest {longest = substr.len()}
//     }
//     longest as i32
// }


pub fn first_uniq_char(s: String) -> i32 {
    let mut chars = [0; 27];
    for c in s.chars() {
        let index = c as u8 - 97;
        chars[index as usize] += 1;
    }
    for (i, c) in s.chars().enumerate() {
        let index = c as u8 - 97;
        if chars[index as usize] == 1 {
            return i as i32;
        }
    }
    -1
}

// Solution using HashMap but I think using an static array is better
// pub fn first_uniq_char(s: String) -> i32 {
//     use std::collections::HashMap;
//     let mut map :HashMap<char, i32> = HashMap::new();
//     for c in s.chars() {
//         map.entry(c).and_modify(|counter| *counter += 1).or_insert(1);
//     }
//     for (i,c) in s.chars().enumerate() {
//         if map.get(&c).unwrap() == &1 {
//             return i as i32;
//         }
//     }
//     -1
// }


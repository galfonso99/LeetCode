static MAPPING: &[&[char]] = &[&['a', 'b', 'c'], &['d', 'e', 'f'], 
            &['g', 'h', 'i'], &['j', 'k', 'l'], &['m', 'n', 'o'], 
            &['p', 'q', 'r', 's'], &['t', 'u', 'v'], &['w', 'x', 'y', 'z']];

pub fn letter_combinations(digits: String) -> Vec<String> {
    use std::collections::VecDeque;
    let digits = digits.chars().map(|c| c.to_digit(10).unwrap() as u8).collect::<VecDeque<u8>>();
    if digits.len() == 0 {return vec![];}
    let mut result: Vec<String> = vec![];
    fn explore(mut comb: Vec<char>, mut rest: VecDeque<u8>, acc: &mut Vec<String>) {
        if rest.is_empty() {
            let string = comb.iter().collect::<String>(); 
            acc.push(string);
            return;
        }
        let digit = rest.pop_front().unwrap();
        let index = digit as usize - 2;
        let letters = MAPPING[index];
        for &char in letters.into_iter() {
            let mut new_comb = comb.to_owned();
            new_comb.push(char);
            explore(new_comb, rest.to_owned(), acc);
        }

    }
    explore(vec![], digits, &mut result);
    result
}

// pub fn letter_combinations(digits: String) -> Vec<String> {
//     let mapping = vec![vec!['a', 'b', 'c'], vec!['d', 'e', 'f'], vec!['g', 'h', 'i'], vec!['j', 'k', 'l'], vec!['m', 'n', 'o'], vec!['p', 'q', 'r', 's'], vec!['t', 'u', 'v'], vec!['w', 'x', 'y', 'z']];
//     let mut sorted_digits = digits.chars().collect::<Vec<char>>();
//     sorted_digits.sort();
//     let letters = sorted_digits.iter().map(|c| {let idx = c.to_digit(10).unwrap() as usize; mapping[idx - 2].clone()}).collect::<Vec<Vec<char>>>();
//     let mut result: Vec<String> = vec![];
//     match sorted_digits.len() {
//         1 => letters[0].iter().map(|c| c.to_string()).collect::<Vec<String>>(),
//         2 => {
//             for a in letters[0].iter() {
//                 for b in letters[1].iter() {
//                     result.push( format!("{}{}", a, b));
//                 }
//             }
//             result
//         },
//         3 => {
//             for a in letters[0].iter() {
//                 for b in letters[1].iter() {
//                     for c in letters[2].iter() {
//                         result.push( format!("{}{}{}", a, b, c));
//                     }
//                 }
//             }
//             result
//         },
//         4 => {
//             for a in letters[0].iter() {
//                 for b in letters[1].iter() {
//                     for c in letters[2].iter() {
//                         for d in letters[3].iter(){
//                             result.push( format!("{}{}{}{}", a, b, c, d));
//                         }
//                     }
//                 }
//             }
//             result
//         },
//         _ => vec![],
//     }
// }


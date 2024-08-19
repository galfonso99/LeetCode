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



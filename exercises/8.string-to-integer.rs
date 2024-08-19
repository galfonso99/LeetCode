impl Solution {
    pub fn my_atoi(mut s: String) -> i32 {
        s = s.trim_start_matches(' ').to_string();
        let mut sign = 1;
        if s.starts_with("-") || s.starts_with("+") {
            if let Some('-') = s.chars().next() {
                sign = -1;
            }
            s = (&s[1..]).to_string();
        }
        s = s.trim_start_matches("0").to_string();
        s = s.chars().take_while(|c| c.is_ascii_digit()).collect();
        if s.len() > 10 {if sign == -1 {return i32::MIN;} else {return i32::MAX;}};
        let mut x: i64 = s.parse().unwrap_or(0) * sign;
        x = if x < i32::MIN.into() {i32::MIN.into()} 
                else if x > i32::MAX.into() {i32::MAX.into()} 
                    else {x};
        x as i32
    }
}

// pub fn my_atoi(s: String) -> i32 {
//         let mut read = s.chars();
//         let mut result: String = String::new();
//         let mut reading_strings = false;
//         let mut negative = false;
//         while let Some(thing) = read.next(){
//             match thing {
//                 '0'..='9' => { reading_strings = true; result.push(thing); },
//                 '-' => { if reading_strings { break; } reading_strings = true; negative = true; },
//                 '+' => { if reading_strings { break; } reading_strings = true; },
//                 ' ' => if reading_strings { break; },
//                 _ => break
//             }
//         }
//         if negative { result = String::from("-") + &result; }
//         match result.parse::<i32>() {
//             Ok(val) => val,
//             Err(message) => match message.kind(){
//                 std::num::IntErrorKind::PosOverflow => i32::MAX,
//                 std::num::IntErrorKind::NegOverflow => i32::MIN,
//                 _ => 0
//             }
//         }
//    } 

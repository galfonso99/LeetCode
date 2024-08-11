pub fn fizz_buzz(n: i32) -> Vec<String> {
    (1..=n).map(|i| 
        if i % 15 == 0 {"FizzBuzz".to_string()} 
        else if i % 3 == 0 {"Fizz".to_string()} 
        else if i % 5 == 0 {"Buzz".to_string()} 
        else {i.to_string()}
        ).collect::<Vec<String>>()
}

// Pleb answer
// pub fn fizz_buzz(n: i32) -> Vec<String> {
    // let mut answer: Vec<String> = Vec::new();
    // for i in 0..n as usize {
    //     let x = i + 1;
    //     if x % 15 == 0 {
    //         answer.push("FizzBuzz".to_string());
    //     } else if x % 3 == 0 {
    //         answer.push("Fizz".to_string());
    //     } else if x % 5 == 0 {
    //         answer.push("Buzz".to_string());
    //     } else {
    //         answer.push(x.to_string());
    //     }
    // }
    // answer
// 

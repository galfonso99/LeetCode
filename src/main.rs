

pub fn main() {
    use std::fs::File;
use std::io::BufReader;
use std::io::prelude::*;
    // let input = "1abc2\n
    //     pqr3stu8vwx\n
    //     a1b2c3d4e5f\n
    //     treb7uchet".to_string();
    let file = File::open("input").unwrap();
    let mut buf_reader = BufReader::new(file);
    let mut contents = String::new();
    buf_reader.read_to_string(&mut contents).unwrap();
    let int_arrays = contents.lines().map(|line| line.chars().filter_map(|c| c.to_digit(10)).collect::<Vec<u32>>())
                        .filter(|arr| !arr.is_empty()).collect::<Vec<Vec<u32>>>();
    let sum: u32 = int_arrays.iter().map(|arr| arr[0] * 10 + arr[arr.len()-1]).sum();
    println!("{:?}", sum);
}

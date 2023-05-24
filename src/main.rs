fn main() {}

pub fn reverse_bits(x: u32) -> u32 {
    let bit_string = x.to_ne_bytes().iter().map(|b| {
        let mut byte = *b;
        let mut str = String::new();
        for i in 0..=7 {
            let sig_bit = 2u8.pow(7-i);
            if sig_bit >= byte {
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
    
    
    // to_string()
    //     .chars()
    //     .rev()
    //     .collect::<String>()
    //     .parse()
    //     .unwrap()

    //"vsdv".
}

/*     table.iter().skip_while(|line| {
        if line.chars().next().unwrap() == '+' {row += 1;}
        row < coords[1][0] + 1
    })
    .skip(1)
    .take_while(|line| {
        if line.chars().next().unwrap() == '+' {row += 1;}
        row <= coords[0][0] + 1
    })
}
*/
/*
table.iter().map(|line| {
    if row < coords[1][0] + 1|| row > coords[0][0] {return line}
    if line.chars().next().unwrap() == '+' {row += 1;}
    line.chars().map(|c| {
        if col < coords[0][1] + 1 || col > coords[1][1] {return c;}
        if c == '|' || c == '*' {
            col += 1;
        }
        return ' ';

    }).collect::<String>()
}).collect::<Vec<String>>()
*/

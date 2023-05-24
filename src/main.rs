fn main() {}

pub fn reverse_bits(x: u32) -> u32 {
    x.reverse_bits()
    
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

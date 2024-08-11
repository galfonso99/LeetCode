pub fn reverse_string(s: &mut Vec<char>) {
    let len = s.len();
    for i in 0..len / 2 {
        let end = len - 1 - i;
        let temp = s[end];
        s[end] = s[i];
        s[i] = temp;
    }
}


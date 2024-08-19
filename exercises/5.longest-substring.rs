    pub fn longest_palindrome(s: String) -> String {
    let chars = s.as_bytes();
    let mut the_longest: &[u8] = &chars[0..1];
    let mut i = 0;
    let mut left_pointer;
    let mut right_pointer;
    while i < chars.len() - 1 {
        left_pointer = i;
        right_pointer = i;
        while right_pointer < chars.len() - 1 && chars[left_pointer] == chars[right_pointer + 1] {
            right_pointer += 1;
        }
        i = right_pointer + 1;
        while left_pointer > 0 && right_pointer < chars.len() - 1 && chars[left_pointer - 1] == chars[right_pointer + 1] {
            left_pointer -= 1;
            right_pointer += 1;
        }
        if the_longest.len() < right_pointer - left_pointer + 1 {
            the_longest = &chars[left_pointer..=right_pointer];
        }
    }
    String::from_utf8_lossy(the_longest).to_string()
}

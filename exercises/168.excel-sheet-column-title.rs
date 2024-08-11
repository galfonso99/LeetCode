impl Solution {
    pub fn convert_to_title(mut n: i32) -> String {
        let mut st: String = String::new();
        let mut f = n as f64;
        if n == 1 {
            return String::from("A");
        }
        while f >= 1.0 {
            let mut tmp: u8 = (f as u64 % 26) as u8;
            if tmp == 0 {
                tmp = 26
            }
            f = ((f / 26.0) - 0.01).floor();
            st.insert(0, (tmp + 64) as char);
        }
        st
    }
}

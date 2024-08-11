pub fn reverse(mut x: i32) -> i32 {
    let mut res: i32 = 0;
    let neg = if x < 0 { -1 } else { 1 };
    x = x.abs();
    while x > 0 {
        let last = x % 10;
        // Try to mult by ten if overflow return 0
        let temp_res = res.checked_mul(10);
        if temp_res == None {
            return 0;
        }
        res = temp_res.unwrap();
        res += last;
        x /= 10;
    }
    res * neg
}


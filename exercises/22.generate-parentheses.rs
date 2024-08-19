struct Solution;

impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        let mut arr = Vec::new();
        Solution::rec("".to_string(), 0, 0, n, &mut arr);
        arr
    }

    pub fn rec (curr: String, open: i32, close: i32, n: i32, arr: &mut Vec<String>) {
        if open == n && close == n {
            arr.push(curr);
            return
        } 
        if open < n {
            let new_string = format!("{}{}", curr, '(');
            Solution::rec(new_string, open + 1, close, n, arr);
        }
        if open - close > 0 && close < n {
            let new_string = format!("{}{}", curr, ')'); 
            Solution::rec(new_string, open, close + 1, n, arr);
        }
    }
}


impl Solution {
    pub fn partition(s: String) -> Vec<Vec<String>> {
        let n = s.len();
        let s_chars: Vec<char> = s.chars().collect();
        
        let mut dp = vec![vec![false; n]; n];
        for i in 0..n {
            for j in 0..=i {
                if s_chars[i] == s_chars[j] && (i as i32 - j as i32 <= 2 || 
                   (j + 1 < n && i > 0 && dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        fn backtrack(
            s: &[char], 
            dp: &Vec<Vec<bool>>, 
            pos: usize, 
            path: &mut Vec<String>, 
            result: &mut Vec<Vec<String>>
        ) {
            if pos == s.len() {
                result.push(path.clone());
                return;
            }
            for i in pos..s.len() {
                if dp[pos][i] {
                    path.push(s[pos..=i].iter().collect());
                    backtrack(s, dp, i + 1, path, result);
                    path.pop();
                }
            }
        }
        let mut result = Vec::new();
        let mut path = Vec::new();
        backtrack(&s_chars, &dp, 0, &mut path, &mut result);
        
        result
    }
}

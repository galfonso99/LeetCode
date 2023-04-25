/*
 * @lc app=leetcode id=20 lang=rust
 *
 * [20] Valid Parentheses
 */

struct Solution;

// @lc code=start
impl Solution {
    pub fn is_valid(s: String) -> bool {
        let mut stack = Vec::new();
        for i in s.chars() {
            match i {
                '{' => stack.push('}'),
                '(' => stack.push(')'),
                '[' => stack.push(']'),
                '}'|')'|']' if Some(i) != stack.pop() => return false,
                _ => (),
            }
        }   
        return stack.is_empty();
    }
    
}


// @lc code=end

/**
 * Original solution
 * pub fn is_valid(s: String) -> bool {
        use std::collections::HashMap;
        let mut stack = Vec::new();
        let pairs = HashMap::from([
            ('{', '}'),
            ('(', ')'),
            ('[', ']'),
        ]);
        for ch in s.chars() {
            match ch {
                '{' | '(' | '[' => {
                    stack.push(ch);
                },
                '}' | ')' | ']' => {
                    if let Some(last) = stack.pop() {
                        if pairs.get(&last).unwrap_or(&'_') != &ch {
                            return false;
                        }
                    } else {
                        return false;
                    }
                },
                _ => {return false; }
            } 
        }
        stack.is_empty()
    }
 */
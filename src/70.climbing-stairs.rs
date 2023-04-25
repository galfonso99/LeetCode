/*
 * @lc app=leetcode id=70 lang=rust
 *
 * [70] Climbing Stairs
 */

// @lc code=start
impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        if n <= 3 {return n;}
        let (mut prev1, mut prev2) = (2,1);
        for x in 3..=n {
            std::mem::swap(&mut prev2,&mut prev1);
            prev1 += prev2;    // Values of prev1 and prev1 switched places
        }
        
        prev1


    }
}
// @lc code=end


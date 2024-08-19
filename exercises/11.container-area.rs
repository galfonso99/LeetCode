impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        let mut max = 0;
        let s = height.len();
        let (mut left, mut right) = (0, s - 1);
        while left < right {
            let h = height[left].min(height[right]);
            max = max.max(h * (right - left) as i32);
            if height[left] < height[right] {
                left += 1;
            } else {
                right -= 1;
            }
        }
        max
    }

}

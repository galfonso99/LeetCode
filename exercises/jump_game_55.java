class Solution {
    public boolean canJump(int[] nums) {
		int minimum_jump = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			minimum_jump += 1;
			if (nums[i] >= minimum_jump) {
				minimum_jump = 0;
			}
		}
		boolean can_reach_end = minimum_jump == 0;
		return can_reach_end;
    }
}

// Go backwards through the loop starting from the penultimate element
// Keep a count of how much to reach the next closest good path position and reset to 0 
// if the current position is a good path position
// Then hopefully the first element can reach the next closest good path position
// But if not then the minimum_jump value will be greater than zero and the code will 
// return false

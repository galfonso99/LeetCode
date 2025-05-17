// EASY
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		 for (int i = 0; i < nums.length; i++) {
			 var prev_index = map.get(nums[i]);
			 if (prev_index != null && Math.abs(prev_index - i) <= k) {
				 return true;
			 }
			 map.put(nums[i], i);
		 }
		 return false;
    }
}

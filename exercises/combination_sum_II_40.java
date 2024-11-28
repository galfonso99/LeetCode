import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
	public List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
		recurse(nums, combs, new ArrayList<Integer>(), target, 0);
		return combs;
	}

	private void recurse(int[] nums, List<List<Integer>> combs,
			List<Integer> comb, int target, int start) {

		if (target == 0) combs.add(new ArrayList<Integer>(comb));
		for (int i = start; i < nums.length; i++) {
			if (i != start && nums[i] == nums[i - 1]) continue;
			if (target - nums[i] < 0) continue;
			comb.add(nums[i]);
			recurse(nums, combs, comb, target - nums[i], i + 1);
			comb.remove(comb.size() - 1);
		}
	}
}

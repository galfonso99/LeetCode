import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		_subsets(nums, new ArrayList<Integer>(), subsets, 0);
		return subsets;
    }
	public void _subsets(int[] input, List<Integer> subset, List<List<Integer>> subsets, int start) {
		subsets.add(new ArrayList<Integer>(subset));
		for (var i = start; i < input.length; i++) {
			subset.add(input[i]);
			_subsets(input, subset, subsets, i + 1);
			subset.removeLast();
		}
	}
}


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        f(0, nums, subset, subsets);
        return subsets;
    }
    private void f(int index, int[] nums, List<Integer> subset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            f(i + 1, nums, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }
}


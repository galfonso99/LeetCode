import java.util.List;
import java.util.ArrayList;
class Solution { 
    int target;
    int[] candidates;
    List<List<Integer>> combs;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
		this.combs = new ArrayList<List<Integer>>();
		recurse(new ArrayList<Integer>(), target, 0);
		return this.combs;
    }
    private void recurse(List<Integer> comb, int target, int start) {
		if (target == 0) combs.add(new ArrayList<Integer>(comb));
		for (var i = start; i < candidates.length; i++) {
			if (target - candidates[i] >= 0) {
				comb.add(candidates[i]);
				recurse(comb, target - candidates[i], i);
				comb.removeLast();
			}
		}
	}
}


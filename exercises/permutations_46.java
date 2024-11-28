import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.HashMap;

// Optimal Solution using visited array
class Solution {
    public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> perms = new ArrayList<List<Integer>>();
		boolean[] visited = new boolean[nums.length];
		_permute(nums, visited, perms, new ArrayList<Integer>()); 
		return perms;
    }
    private void _permute(int[] nums, boolean[] visited, List<List<Integer>> perms, List<Integer> perm) {
		if (perm.size() == nums.length) perms.add(new ArrayList<Integer>(perm));
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				perm.add(nums[i]);
				visited[i] = true;
				_permute(nums, visited, perms, perm);
				visited[i] = false;
				perm.remove(perm.size() - 1);
			}
		}
	}
}

// Original Solution using LinkedHashMap
//class Solution {
//    public List<List<Integer>> permute(int[] nums) {
//		HashMap<Integer, Integer> hm = new LinkedHashMap<>();
//		List<List<Integer>> perms = new ArrayList<List<Integer>>();
//		_permute(nums, perms, hm); 
//		return perms;
//    }
//    private void _permute(int[] nums, List<List<Integer>> perms, HashMap<Integer, Integer> hashmap) {
//		if (hashmap.size() == nums.length) perms.add(new ArrayList<Integer>(hashmap.keySet()));
//		for (int i = 0; i < nums.length; i++) {
//			if (!hashmap.containsKey(nums[i])) {
//				hashmap.put(nums[i], i);
//				_permute(nums, perms, hashmap);
//				hashmap.remove(nums[i]);
//			}
//		}
//	}
//}



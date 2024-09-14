import java.util.List;
// import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<int[]> counts = new ArrayList<int[]>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (var key : map.keySet()) {
            int[] count = {key, map.get(key)}; 
            counts.add(count);
        }
        counts.sort((a, b) ->  b[1] - a[1]);
        // ArrayList<Integer> res = new ArrayList<>();
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = counts.get(i)[0];
        }
        return res;
    }
}

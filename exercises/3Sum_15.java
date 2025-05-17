import java.util.ArrayList;
import java.util.Arrays;
i
class Solution_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            var val = nums[i];
            if (i > 0 && val == nums[i - 1]) { continue; }
            if (val > 0) { break; }

            var l = i + 1;
            var r = nums.length - 1;
            while (l < r) {
                var diff = 0 - (nums[l] + nums[r]);
                if (val > diff) { r -= 1; } 
                else if (val < diff) { l += 1; } 
                else {
                    res.add(Arrays.asList(val, nums[l], nums[r]));
                    l += 1;
                    r -= 1;
                    while (nums[l] == nums[l - 1]) {
                        l += 1;
                    }
                }
            }
        }
        return res;
    }
}

/* Steps thinking through the problem (pseudocode) */
// Firstly sort the array nlogn
// For each value of nums less than or equal to zero do the following
// Setup the left and right pointers
// while l < r
// Take the sum and if zero then add it
// if less then move left forward
// if greater then move right backward
// Only do this if sum equal zero: while value of left == value of left - 1 move left up
// return res

/* Original crazy attempt (too slow tho) */
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         HashMap<Integer, List<int[]>> hm = new HashMap<>();
//         int prev = -55555;
//         for (int i = 0; i < nums.length; i++) {
//             if (prev == nums[i])
//                 continue;
//             int nested_prev = -5555;
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (nested_prev == nums[j])
//                     continue;
//                 var val = 0 - (nums[i] + nums[j]);
//                 if (!hm.containsKey(val)) {
//                     hm.put(val, new ArrayList<>());
//                 }
//                 hm.get(val).add(new int[] { i, j });
//                 nested_prev = nums[j];
//             }
//             prev = nums[i];
//         }
//         Map<String, int[]> array_map = new HashMap<String, int[]>();
//         for (int i = 0; i < nums.length; i++) {
//             if (hm.containsKey(nums[i])) {
//                 for (var indices : hm.get(nums[i])) {
//                     if (i == indices[0] || i == indices[1])
//                         continue;
//                     int[] sorted_array = { nums[i], nums[indices[0]], nums[indices[1]] };
//                     Arrays.sort(sorted_array);
//                     array_map.put(Arrays.toString(sorted_array), sorted_array);
//                 }
//             }
//         }
//         for (int[] array : array_map.values()) {
//             List<Integer> list = new ArrayList<>();
//             for (int num : array) {
//                 list.add(num);
//             }
//             res.add(list);
//         }
//         return res;
//     }
// }

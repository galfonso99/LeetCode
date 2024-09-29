
import java.util.HashMap;
import java.util.HashSet;

public class longest_consecutive_sequence_128 {
    public static void main(String[] args) {
        var sol = new Solution_128();
        System.out.println(sol.longestConsecutive(new int[] {4, 100, 2, 200, 1, 3, 7}));
    }
}

// Solution with real O(n) no nested loops only one outer loop
class Solution_128 {
    public int longestConsecutive(int [] nums) {
        var set = new HashSet<Integer>();
        var map = new HashMap<Integer, Integer>();
        var longest = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            var x = map.getOrDefault(num - 1, 0);
            var y = map.getOrDefault(num + 1, 0);
            var val = x + y + 1;
            map.put(num - x, val);
            map.put(num + y, val);
            longest = Math.max(longest, val);
        }
        return longest;
    }
}

// Solution using Set (Standard)
//class Solution_128 {
//    public int longestConsecutive(int[] nums) {
//        var set = new HashSet<Integer>();
//        var longest = 0;
//        for (int num : nums) {
//            set.add(num);
//        }
//        for (int num : set) {
//            if (!set.contains(num - 1)) {
//                var y = num + 1;
//                while (set.contains(y)) {
//                    y += 1;
//                }
//                longest = Math.max(longest, y-num);
//            }
//        }
//
//        return longest;
//    }
//}


// First Solution (using sort on purpose - problem asked for O(n) )
// class Solution_128 {
//     public int longestConsecutive(int[] nums) {
//         Arrays.sort(nums);
//         var longest_sequence = 1;
//         var current_sequence = 1;
//         var prev = -99999;
//         var i = 0;
//         while (i < nums.length) {
//             if (nums[i] == prev) continue;
//             if (nums[i] - prev > 1) {
//                 prev = nums[i];
//                 longest_sequence = current_sequence > longest_sequence ? current_sequence : longest_sequence;
//                 current_sequence = 1;
//                 continue;
//             } else {
//                 prev = nums[i];
//                 current_sequence += 1;
//             }
//             i++;
//         }
//         return longest_sequence;
//     }
// }

import java.util.ArrayList;
import java.util.List;

// Complete optimization absolute. Replaced HashMap with alphabet array Beats 99% #3
class Solution {
    public List<Integer> partitionLabels(String s) {
		List<Integer> res = new ArrayList<>();
		int[] rightmost = new int[26];
		char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            rightmost[charArray[i] - 'a'] = i;
        }
		int i = 0;
		int ending = 0;
		while (i < charArray.length) {
			int start = i;
			while (i <= ending) {
				char ch = charArray[i];
				if (rightmost[ch - 'a'] > ending) {
					ending = rightmost[ch-'a'];
				}
				i++;
			}
			res.add(ending - start + 1);
			ending += 1;
		}
		return res;
	}
}

// Also max optimized by another coder #4
// class Solution {
//     public List<Integer> partitionLabels(String s) {
//         int[] lastOccurrence = new int[26];
//         for (int i = 0; i < s.length(); i++) {
//             lastOccurrence[s.charAt(i) - 'a'] = i;
//         }
//         int partitionEnd = 0, partitionStart = 0;
//         List<Integer> partitionSizes = new ArrayList<>();
//
//         for (int i = 0; i < s.length(); i++) {
//             partitionEnd = Math.max(partitionEnd, lastOccurrence[s.charAt(i) - 'a']);
//             if (i == partitionEnd) {
//                 partitionSizes.add(i - partitionStart + 1);
//                 partitionStart = i + 1;
//             }
//         }
//         return partitionSizes;
//     }
// }

// Complete rewrite after the disappointment of the first solution #2
// class Solution {
//     public List<Integer> partitionLabels(String s) {
// 		List<Integer> res = new ArrayList<>();
// 		HashMap<Character, Integer> rightmost = new HashMap<>();
// 		char[] charArray = s.toCharArray();
// 		for (int i = charArray.length - 1; i >= 0; i--) {
// 			rightmost.putIfAbsent(charArray[i], i);
// 		}
// 		int i = 0;
// 		int ending = 0;
// 		while (i < charArray.length) {
// 			boolean canPartition = false;
// 			int start = i;
// 			while (i <= ending) {
// 				char ch = charArray[i];
// 				if (rightmost.get(ch) > ending) {
// 					ending = rightmost.get(ch);
// 				}
// 				i++;
// 			}
// 			res.add(ending - start + 1);
// 			ending += 1;
// 		}
// 		return res;
// 	}
// }
// Original Passing Solution (Sloppy) #1
// class Solution {
//     public List<Integer> partitionLabels(String s) {
// 		List<Integer> res = new ArrayList<>();
// 		HashMap<Character, Integer> mp = new HashMap<>();
//         char[] charArray = s.toCharArray();
// 		for (char ch : charArray) {
// 			mp.put(ch, mp.getOrDefault(ch, 0) + 1);
// 		}
// 		HashSet<Character> set = new HashSet<>();
// 		int partition_length = 0;
// 		int count = 0;
// 		for (var ch : charArray) {
// 			mp.put(ch, mp.get(ch) - 1);
// 			partition_length += 1;
// 			if (mp.get(ch) > 0 && !set.contains(ch)) {
// 				set.add(ch);
//                 count += mp.get(ch);
// 			} else if (set.contains(ch)) {
// 				count -= 1;
// 			}
// 			if (count == 0) {
// 				res.add(partition_length);
// 				partition_length = 0;
// 				count = 0;
//                 set.clear();
// 			}
// 		}
// 		return res;
//     }
// }

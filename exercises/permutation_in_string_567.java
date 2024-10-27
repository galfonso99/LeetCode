// Fast Optimal Solution [MINE] using Arrays (of course)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
		int n = s1.length();
		int[] map = new int[28];
		for (int i = 0; i < n; i++) map[s1.charAt(i) - 'a'] += 1;
		int l = 0, r = 0;
		while ( r < s2.length() ) {
			int ch = s2.charAt(r) - 'a';
			if (map[ch] > 0) {
				map[ch] -= 1;
			} else {
				while (s2.charAt(l) - 'a' != ch) {
					map[s2.charAt(l) - 'a'] += 1;
					l += 1;
				}
				l += 1;
			}
			if ( (r - l + 1) == n ) {
				if (map[ch] == 0) {
					return true;
				}
				l += 1;
			}
			r += 1;
		}
		return false;
    }
}

// Crazy solution comparing Arrays at each turn and its almost as fast as the fastest solution
//import java.util.Arrays;
//class Solution {
//    public boolean checkInclusion(String s1, String s2) {
//		var l1 = s1.length();
//		var l2 = s2.length();
//		if (l1 > l2) return false;
//        int[] f1 = new int[28];
//        int[] f2 = new int[28];
//		for (int i = 0; i < l1; i++) {
//            f1[s1.charAt(i) - 'a'] += 1;
//            f2[s2.charAt(i) - 'a'] += 1;
//		}
//		if (Arrays.compare(f1, f2) == 0) {
//			return true;
//		}
//		for (int i = l1; i < l2; i++) {
//            f2[s2.charAt(i - l1) - 'a'] -= 1;
//            f2[s2.charAt(i) - 'a'] += 1;
//			if (Arrays.compare(f1, f2) == 0) {
//				return true;
//			}
//		}
//		return false;
//    }
//}

// Original Brute Force Solution
//import java.util.HashMap;
//class Solution {
//    public boolean checkInclusion(String s1, String s2) {
//		int n = s1.length();
//		HashMap<Character, Integer> map = new HashMap<>();
//		for (int i = 0; i < n; i++) {
//			int val = map.getOrDefault(s1.charAt(i), 0);
//			map.put(s1.charAt(i), val + 1);
//		}
//		int l = 0;
//		int r = 0;
//		while ( r < s2.length() ) {
//			char ch = s2.charAt(r);
//			if (!map.containsKey(ch)) {
//				l = r + 1;
//			}
//			if ( (r - l + 1) == n ) {
//				boolean isIncluded = testForInclusion(map, s2, l, r);
//				if (isIncluded) {
//					return true;
//				}
//                l += 1;
//			}
//			r += 1;
//		}
//		return false;
//    }
//	boolean testForInclusion(HashMap<Character, Integer> map, String s, int l, int r) {
//		HashMap<Character, Integer> localMap = new HashMap<>();
//		for (int i = l; i <= r; i++) {
//			int val = localMap.getOrDefault(s.charAt(i), 0);
//			localMap.put(s.charAt(i), val + 1);
//			if (val + 1 > map.get(s.charAt(i))) {
//				return false;
//			}
//		}
//		return true;
//	}
//}

// Kinda faster than original solution by keeping state for the current window (l -> r)
//class Solution {
//    public boolean checkInclusion(String s1, String s2) {
//		int n = s1.length();
//		HashMap<Character, Integer> map = new HashMap<>();
//		for (int i = 0; i < n; i++) {
//			int val = map.getOrDefault(s1.charAt(i), 0);
//			map.put(s1.charAt(i), val + 1);
//		}
//		int l = 0;
//		int r = 0;
//		while ( r < s2.length() ) {
//			char ch = s2.charAt(r);
//			if (map.containsKey(ch)) {
//				map.put(ch, map.get(ch) - 1);
//			} else {
//				while (l <= r) {
//					map.put(ch, map.get(ch) + 1);
//					l += 1;
//				}
//			}
//
//			if ( (r - l + 1) == n ) {
//				boolean isIncluded = testForInclusion(map, s2, l, r);
//				if (isIncluded) {
//					return true;
//				}
//				l += 1;
//			}
//			r += 1;
//		}
//		return false;
//    }
//	boolean testForInclusion(HashMap<Character, Integer> map, String s, int l, int r) {
//		for (var count : map.values()) {
//			if (count > 0) {
//				return false;
//			}
//		}
//		return true;
//	}
//}

/*
INSTRUCTIONS
567. Permutation in String
Given two strings s1 and s2, return true if s2 contains a
permutation
of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false



Constraints:

    1 <= s1.length, s2.length <= 104
    s1 and s2 consist of lowercase English letters.

*/

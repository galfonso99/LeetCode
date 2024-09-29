import java.util.List;
import java.util.ArrayList;
import java.lang.Character;

// Fast solution (MINE) First attempt I made knowing it might pass (2 ms runtime)
// Knowing that linear searching through the String is really fast actually
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            int duplicateInd = contains(s, s.charAt(r), l, r);
            if (duplicateInd != -1) {
                longest = Math.max(r - l, longest);
                l = duplicateInd + 1;
            }
            r++;
        }
        longest = Math.max(r - l, longest);
        return longest;
    }
    int contains(String s, char ch, int l, int r) {
        for (; l < r; l++) if (s.charAt(l) == ch) return l;
        return -1;
    } 
}
// Hashset solution to compare (6 ms runtime)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> seen = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (!seen.containsKey(s.charAt(i)) || seen.get(s.charAt(i)) < left) {
                maxLen = Math.max(maxLen, i - left + 1);
            } else {
                left = seen.get(s.charAt(i)) + 1;
            }
            seen.put(s.charAt(i), i);
        }
        return maxLen;
    }
}

// Super Fast Solution using a pseudo HashMap (Array with enough size to represent all Ascii characters)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, j = 0, n = s.length();
        int index[] = new int[128];  // maps a char value to the next index
        for(int i = 0; i < n; i++) {
            int c = s.charAt(i);
            j = Math.max(index[c],j);
            ans = Math.max(ans,i-j+1);
            index[c] = i+1;
        }
        return ans;
   }
}

// Faulty Wrong Solution that was my first attempt (I knew it wouldn't work but wanted
// to see how it would break)

//public int lengthOfLongestSubstring(String s) {
//    List<Character> tracker = new ArrayList<Character>();
//    int longest = 0;
//    for (int i = 0; i < s.length(); i++) {
//        char ch = s.charAt(i);
//        if (tracker.contains(ch)) {
//            longest = tracker.size() > longest ? tracker.size() : longest;
//            tracker.clear();
//        }
//        tracker.add(ch);
//    }
//    if (tracker.size() > longest) longest = tracker.size();
//    return longest;
//}

/*
Given a string s, find the length of the longest
substring
without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.

*/

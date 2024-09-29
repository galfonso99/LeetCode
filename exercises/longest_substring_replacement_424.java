class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[28];
        int longest = 0;
        int l = 0;
        int r = 0;
        char currChar = s.charAt(0);
        while (r < s.length()) {
            int ch = currChar - 'A';
            count[s.charAt(r) - 'A'] += 1;
            if (r - l + 1 - count[ch] > k) {
                while (s.charAt(l) == currChar) {
                    count[currChar - 'A'] -= 1;
                    l += 1;
                }
                currChar = s.charAt(l);
                r++;
                continue;
            }
            longest = Math.max(r - l + 1, longest);
            r++;
        }
        if (r - l - count[currChar - 'A'] < k) {
            var leftOver = Math.min(l, k - (r - l - count[currChar - 'A']));
            longest = Math.max(r - l + leftOver, longest);
        }
        l = r - count[s.charAt(r - 1) - 'A'] - 1;
        var leftOver = Math.min(l, k - (r - l - count[s.charAt(r - 1) - 'A']));
        longest = Math.max(r - l + leftOver, longest);

        return longest;
    }

}

// Much better solution
//class Solution {
//    public int characterReplacement(String s, int k) {
//        int maxLen = 0;
//        int start = 0;
//
//        // count the number of chars so far
//        int[] arr = new int[128];
//        int counter = 0;
//
//        for(int end =0; end<s.length(); end++){
//            arr[s.charAt(end)]++;
//            counter = Math.max(counter, arr[s.charAt(end)]);
//
//            while (end - start +1 - counter >k){
//                arr[s.charAt(start)]--;
//                start++;
//            }
//            maxLen = Math.max(maxLen,end - start + 1);
//        }
//
//        return maxLen;
//
//    }
//}

//array char to int
//keep the count array up to date
//Keep the window going until you cant anaymore and then shift the left pointer right
//until you land on a different character 
//if current longest is longer than longest update longest

//424. Longest Repeating Character Replacement
//You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
//Return the length of the longest substring containing the same letter you can get after performing the above operations.
//
//Example 1:
//
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.
//
//Example 2:
//
//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.
//There may exists other ways to achieve this answer too.
//
//
//
//Constraints:
//
//    1 <= s.length <= 105
//    s consists of only uppercase English letters.
//    0 <= k <= s.length



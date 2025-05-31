// Dynamic Programming keeping a n^2 memo table
class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0, resLen = 0;
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && 
                    (j - i <= 2 || dp[i + 1][j - 1])) {
                        
                    dp[i][j] = true;
                    if (resLen < (j - i + 1)) {
                        resIdx = i;
                        resLen = j - i + 1;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }
}

// Way more optimized but similar to my original solution
// class Solution {
//     public String longestPalindrome(String s) {
//         if (s == null || s.length() < 2) {
//             return s;
//         }
//         int start = 0;
//         int maxLength = 1;
//         for (int i = 0; i < s.length(); i++) {
//             int oddLength = expandAroundCenter(s, i, i);
//             int evenLength = expandAroundCenter(s, i, i + 1);
//
//             int currentMax = Math.max(oddLength, evenLength);
//             if (currentMax > maxLength) {
//                 maxLength = currentMax;
//                 start = i - (currentMax - 1) / 2;
//             }
//         }
//         return s.substring(start, start + maxLength);
//     }
//
//     private int expandAroundCenter(String s, int left, int right) {
//         while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//             left--;
//             right++;
//         }
//         return right - left - 1;
//     }
// }

// Most efficient solution, impossible to remember
// public class Solution {
//     public int[] manacher(String s) {
//         StringBuilder t = new StringBuilder("#");
//         for (char c : s.toCharArray()) {
//             t.append(c).append("#");
//         }
//         int n = t.length();
//         int[] p = new int[n];
//         int l = 0, r = 0;
//         for (int i = 0; i < n; i++) {
//             p[i] = (i < r) ? Math.min(r - i, p[l + (r - i)]) : 0;
//             while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 &&
//                    t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
//                 p[i]++;
//             }
//             if (i + p[i] > r) {
//                 l = i - p[i];
//                 r = i + p[i];
//             }
//         }
//         return p;
//     }
//
//     public String longestPalindrome(String s) {
//         int[] p = manacher(s);
//         int resLen = 0, center_idx = 0;
//         for (int i = 0; i < p.length; i++) {
//             if (p[i] > resLen) {
//                 resLen = p[i];
//                 center_idx = i;
//             }
//         }
//         int resIdx = (center_idx - resLen) / 2;
//         return s.substring(resIdx, resIdx + resLen);
//     }
// }

// Original working solution kinda shitty not polished
// class Solution {
//     public String longestPalindrome(String s) {
// 		int res_len = 1;
// 		int res = 0;
// 		for (int i = 0; i < s.length(); i++) {
// 			char ch = s.charAt(i);
// 			int[] odd_endpoints = expand(s, i, i);
// 			int[] even_endpoints = i+1 < s.length() && 
// 								   s.charAt(i) == s.charAt(i+1) ? 
// 								   expand(s, i, i+1) : 
// 								   new int[] {0, 0};
//
// 			int odd_length = odd_endpoints[1] - odd_endpoints[0] + 1;
// 			int even_length = even_endpoints[1] - even_endpoints[0] + 1;
//
// 			if (odd_length > res_len) {
// 				res_len = odd_length;
// 				res = odd_endpoints[0];
// 			}
// 			if (even_length > res_len) {
// 				res_len = even_length;
// 				res = even_endpoints[0];
// 			}
// 		}
// 		return s.substring(res, res + res_len);
//     }
// 	int[] expand(String s, int start, int end) {
// 		if (start - 1 < 0 || end + 1 >= s.length()) {
// 			return new int[] {start, end};
// 		}
// 		if (s.charAt(start - 1) != s.charAt(end+1)) {
// 			return new int[] {start, end};
// 		}
// 		return expand(s, start-1, end+1);
// 	}
// }

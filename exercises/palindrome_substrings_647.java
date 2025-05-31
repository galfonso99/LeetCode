// Dynamic programming solution
class Solution {
    public int countSubstrings(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int palindrome_count = 0;
		for (int i = n-1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])) {
					dp[i][j] = true;
					palindrome_count++;
				}
			}
		}
		return palindrome_count;
    }
}

// Optimized expanding solution (I really like this one since I made it kinda)
// class Solution {
// 	public int countSubstrings(String s) {
// 		int palindrome_count = 0;
// 		for (int i = 0; i < s.length(); i++) {
// 			int odd_count = expand(s, i, i);
// 			int even_count = expand(s, i, i+1);
//
// 			palindrome_count += odd_count + even_count;
// 		}
// 		return palindrome_count;
//
// 	}
// 	int expand(String s, int i, int j) {
// 		int count = 0;
// 		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
// 			i--;
// 			j++;
// 			count++;
// 		}
// 		return count;
// 	}
// }

// Solution in O(n) insane stuff
// class Solution {
//     public int countSubstrings(String s) {
//         // Transform string to handle even-length palindromes
//         // "abc" -> "^#a#b#c#$"
//         StringBuilder sb = new StringBuilder();
//         sb.append("^#");
//         for (char c : s.toCharArray()) {
//             sb.append(c).append("#");
//         }
//         sb.append("$");
//
//         String transformed = sb.toString();
//         int n = transformed.length();
//         int[] radius = new int[n]; // radius[i] = radius of palindrome centered at i
//         int center = 0, right = 0; // rightmost palindrome's center and right boundary
//         int totalCount = 0;
//
//         for (int i = 1; i < n - 1; i++) {
//             // Use previously computed information if possible
//             if (i < right) {
//                 int mirror = 2 * center - i; // mirror of i with respect to center
//                 radius[i] = Math.min(right - i, radius[mirror]);
//             }
//
//             // Try to expand palindrome centered at i
//             while (transformed.charAt(i + radius[i] + 1) == 
//                    transformed.charAt(i - radius[i] - 1)) {
//                 radius[i]++;
//             }
//
//             // Update center and right if palindrome centered at i extends past right
//             if (i + radius[i] > right) {
//                 center = i;
//                 right = i + radius[i];
//             }
//
//             // Count palindromes: each radius contributes (radius[i] + 1) / 2 palindromes
//             totalCount += (radius[i] + 1) / 2;
//         }
//
//         return totalCount;
//     }
// }

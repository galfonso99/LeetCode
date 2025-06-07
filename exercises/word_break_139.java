import java.util.HashSet;
import java.util.List;

// Improved Original Bottom-Up solution | O(n*t) t is max wordDict length
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>();
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        
        int maxWordLength = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            set.add(word);
            maxWordLength = Math.max(maxWordLength, word.length());
        }
        
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= s.length() && j - i <= maxWordLength; j++) {
                if (dp[j] && set.contains(s.substring(i, j))) {
                    dp[i] = true;
                    break; // Early termination once we find a valid break
                }
            }
        }
        return dp[0];
    }
}

// Top-Down Approach
// class Solution {
//     private Map<Integer, Boolean> memo;
//
//     public boolean wordBreak(String s, List<String> wordDict) {
//         memo = new HashMap<>();
//         memo.put(s.length(), true);
//         return dfs(s, wordDict, 0);
//     }
//
//     private boolean dfs(String s, List<String> wordDict, int i) {
//         if (memo.containsKey(i)) {
//             return memo.get(i);
//         }
//
//         for (String w : wordDict) {
//             if (i + w.length() <= s.length() && 
//                 s.substring(i, i + w.length()).equals(w)) {
//                 if (dfs(s, wordDict, i + w.length())) {
//                     memo.put(i, true);
//                     return true;
//                 }
//             }
//         }
//         memo.put(i, false);
//         return false;
//     }
// }

// Another example of Bottom-up dp
// public class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         boolean[] dp = new boolean[s.length() + 1];
//         dp[s.length()] = true;
//
//         for (int i = s.length() - 1; i >= 0; i--) {
//             for (String w : wordDict) {
//                 if ((i + w.length()) <= s.length() && 
//                      s.substring(i, i + w.length()).equals(w)) {
//                     dp[i] = dp[i + w.length()];
//                 }
//                 if (dp[i]) {
//                     break;
//                 }
//             }
//         }
//
//         return dp[0];
//     }
// }

// Original Solution (Bottom-Up DP)
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
// 		HashSet<String> set = new HashSet<String>();
// 		boolean[] dp = new boolean[s.length() + 1];
// 		dp[s.length()] = true;
// 		for (int i = 0; i < wordDict.size(); i++) {
// 			set.add(wordDict.get(i));
// 		}
// 		for (int i = s.length(); i >= 0 ; i--) {
// 			for (int j = i + 1; j <= s.length(); j++) {
// 				if (dp[j] && set.contains(s.substring(i, j))) {
// 					dp[i] = true;
// 				}
// 			}
// 		}
// 		return dp[0];
//     }
// }


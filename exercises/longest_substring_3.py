# Most optimal solution while using HashMap (not using HashMap is better)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hm = {}
        maxLen = 0
        i = 0
        for j in range(len(s)):
            ch = s[j]
            if ch not in hm or hm[ch] < i:
                maxLen = max(j - i + 1, maxLen)
            else:
                i = hm[ch] + 1
            hm[ch] = j
        return maxLen

# Fastest solution using static array (in python just a list)
# I learned not to use max for updating a value instead use ternary
# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         index = [0 for _ in range(128)]
#         i, max_len = 0, 0
#         for j in range(len(s)):
#             ch = ord(s[j])
#             i = index[ch] if index[ch] > i else i
#             max_len = j - i + 1 if (j - i + 1) > max_len else max_len
#             index[ch] = j + 1
#         return max_len

# My first solution which was fast in Java but slow in Python
# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         maxLen = 0
#         l, r = 0, 0
#         while (l < r):
#             duplicateInd = self.contains(s, s[r], l, r)
#             if duplicateInd != -1:
#                 maxLen = max(r-l, maxLen)
#                 l = duplicateInd + 1
#             r+=1
#         maxLen = max(r - l, maxLen)
#         return maxLen
#
#     def contains(self, s: str, ch: str, l: int, r: int):
#         for i in range(l, r):
#             if s[i] == ch: return i
#         return -1

# Given a string s, find the length of the longest
# substring
# without repeating characters.
#
# Example 1:
# Input: s = "abcabcbb"
# Output: 3
# Explanation: The answer is "abc", with the length of 3.
#
# Example 2:
# Input: s = "bbbbb"
# Output: 1
# Explanation: The answer is "b", with the length of 1.
#
# Example 3:
# Input: s = "pwwkew"
# Output: 3
# Explanation: The answer is "wke", with the length of 3.
# Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
#
# Constraints:
#
#     0 <= s.length <= 5 * 104
#     s consists of English letters, digits, symbols and spaces.
#

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        list = [0 for _ in range(len(s1))]
        l, r = 0, 0
        while r < len(s2):
            ch = ord(s2[r]) - ord("a")
            if list[ch] > 0:
                list[ch] += 1
            else:
                while s2[l] != s2[r]:
                    list[ord(s2[l]) - ord("a")] += 1
                    l += 1
                l += 1
            if (r - l + 1) == len(s1):
                if list[ch] == 0:
                    return True
                l += 1
        return False
        

#567. Permutation in String
#Given two strings s1 and s2, return true if s2 contains a
#permutation
#of s1, or false otherwise.
#
#In other words, return true if one of s1's permutations is the substring of s2.
#
#
#
#Example 1:
#
#Input: s1 = "ab", s2 = "eidbaooo"
#Output: true
#Explanation: s2 contains one permutation of s1 ("ba").
#
#Example 2:
#
#Input: s1 = "ab", s2 = "eidboaoo"
#Output: false
#
#
#
#Constraints:
#
#    1 <= s1.length, s2.length <= 104
#    s1 and s2 consist of lowercase English letters.
#

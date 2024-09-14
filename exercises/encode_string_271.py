from typing import List

#Optimal Solution
class Solution:
    def encode(self, strs: List[str]) -> str:
       res = ""
       for s in strs:
           res += str(len(s)) + "#" + s
       return res

    def decode(self, s: str) -> List[str]:
        res = []
        i = 0
        
        while i < len(s):
            j = i
            while s[j] != '#':
                j += 1
            length = int(s[i:j])
            i = j + 1
            j = i + length
            res.append(s[i:j])
            i = j
            
        return res

# Original Solution
# class Solution:
#
#     def encode(self, strs: List[str]) -> str:
#         s = ""
#         for str in strs:
#             s = f"{s}{len(str)}#{str}"
#         return s
#
#
#     def decode(self, s: str) -> List[str]:
#         i, j = 0, 0
#         res = []
#         while i < len(s):
#             length = 0
#             while s[j] != '#':
#                 j += 1
#             length = int(s[i:j])
#             res.append(s[j+1:j+length+1])
#             j += length + 1
#             i = j
#         return res
        # while you dont encounter separator you are reading the length, then ignore the separator
    # Then read for the whole length and add the string to the list


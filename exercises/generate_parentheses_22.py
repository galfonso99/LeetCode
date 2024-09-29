from typing import List

# Original Solution using recursion ( recursion uses Stack under the hood )
# class Solution:
#     res: List[str] = []
#     def generateParenthesis(self, n: int) -> List[str]:
#         self.res = []
#         self.recurse(n, n, "")
#         return self.res
#
#     def recurse (self, opening: int, closing: int, comb: str):
#         if opening == 0 and closing == 0:
#             self.res.append(comb)
#             return
#         if opening > 0:
#             self.recurse(opening-1, closing, comb + "(")
#         if closing > opening:
#             self.recurse(opening, closing - 1, comb + ")")


# Solution using Stack ( Managing a stack myself )
# This is actually a very crude translation from recursive to iterative (but it works wonderfully)
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        stack = [(n, n, "")]
        res = []

        while stack:
            opening, closing, comb = stack.pop()
            if opening == 0 and closing == 0:
                res.append(comb)
                continue
            if closing > opening:
                stack.append((opening, closing - 1, comb + ")"))

            if opening > 0:
                stack.append((opening - 1, closing, comb + "("))
        return res


# def generateParenthesis(self, n: int) -> List[str]:
#     ans = []
#     queue = [('(', 1, 0)]  #(str, open_nr, close_nr)
#     f, l = 0, 1
#     while f<l:
#         comb, op, cl = queue[f]
#         if op+cl==2*n:
#             ans.append(comb)
#         elif op < n:
#             queue.append((comb+'(', op+1, cl))
#             l+=1
#         elif op >= cl:
#             queue.append((comb+')', op, cl+1))
#             l+=1
#         f+=1
#     return ans

# class Solution:
#     def generateParenthesis(self, n: int) -> List[str]:
#         ans = []
#         queue = [('(', 1, 0)]  #(str, open_nr, close_nr)
#         f, l = 0, 1
#         while f < l:
#             comb, op, cl = queue[f]
#             if op+cl==2*n:
#                 ans.append(comb)
#                 f+=1
#                 continue
#             if op < n:
#                 queue.append((comb+'(', op+1, cl))
#                 l += 1
#             if op > cl:
#                 queue.append((comb+')', op, cl+1))
#                 l += 1
#             f+=1
#         return ans


# Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
#
#
#
# Example 1:
#
# Input: n = 3
# Output: ["((()))","(()())","(())()","()(())","()()()"]
#
# Example 2:
#
# Input: n = 1
# Output: ["()"]
#
#
#
# Constraints:
#
#     1 <= n <= 8

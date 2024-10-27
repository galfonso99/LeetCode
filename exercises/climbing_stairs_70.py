# Original solution
class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1: return 1
        prev = 1
        curr = 2
        for _ in range(3,n+1):
            ways = curr + prev
            prev = curr
            curr = ways
        return curr

# Memoized recursion
# class Solution:
#     def climbStairs(self, n: int) -> int:
#         arr = [0] * (n + 1)
#         return self.recurse(n, arr)
#
#     def recurse(self, n: int, arr: List[int]):
#         if n < 4: return n
#         if arr[n] > 0: return arr[n]
#         arr[n] = self.recurse(n - 1, arr) + self.recurse(n - 2, arr)
#         return arr[n]

# Solution using recursion that apparently runs faster(not mine)
# class Solution:
#     stairCount = {}
#     def climbStairs(self, n: int) -> int:
#         if n == 1:
#             return 1
#         elif n == 2:
#             return 2
#         elif n in self.stairCount:
#             return self.stairCount[n]
#         else:
#             count = self.climbStairs(n - 1) + self.climbStairs(n - 2)
#             self.stairCount[n] = count
#             return count


from typing import List

# Iterative bottom-up solution (tabulation)
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        prev = 0
        curr = 0
        for i in range(2, len(cost) + 1):
            one_jump = curr + cost[i-1]
            two_jump = prev + cost[i-2]
            prev = curr
            curr = min(one_jump, two_jump)
        return curr

# Recursive solution
# class Solution:
#     def minCostClimbingStairs(self, cost: List[int]) -> int:
#         table = [-1] * (len(cost) + 1)
#
#         def minCost(n: int):
#             if n < 2: return cost[n]
#             if table[n] >= 0: return table[n]
#             table[n] = cost[n] + min(minCost(n-1), minCost(n-2))
#             return table[n]
#
#         return min(minCost(len(cost) - 1), minCost(len(cost) - 2))

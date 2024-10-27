from typing import List

# Best, most optimal, super fast solution
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        n = len(piles)
        total = 0
        for x in piles: total += x
        l = (total - 1) // h + 1
        r = (total - n) // (h - n + 1) + 1
        while l < r:
            mid = (l + r) // 2
            count = 0
            for val in piles:
                count += (val + mid - 1) // mid
            if count > h:
                l = mid + 1
            else:
                r = mid
        return l

# Original Solution
# class Solution:
#     def minEatingSpeed(self, piles: List[int], h: int) -> int:
#         l = 1
#         r = 1000000000
#         ans = 1
#         while l <= r:
#             mid = (l + r) // 2
#             count = 0
#             for val in piles:
#                 count += (val + mid - 1) // mid
#             if count <= h:
#                 ans = mid
#                 r = mid - 1
#             else:
#                 l = mid + 1
#         return ans

# Thought Process
# Sort
# let m = hours / length
# left = array[0] / m
# right = array[array.length - 1]
# Do binary search from l to r on return value 0 set right to middle (do not return)
# for each iteration call a function that tests if the value uses all the hours (-1, 0, 1)
#
#
#875. Koko Eating Bananas
#Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
#
#Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
#
#Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
#
#Return the minimum integer k such that she can eat all the bananas within h hours.
#
#
#[1000000,10000,100,1]  h=8
#
#Example 1:
#
#Input: piles = [3,6,7,11], h = 8
#1,2,2,3
#Output: 4
#
#Example 2:
#
#Input: piles = [30,11,23,4,20], h = 5
#Output: 30
#
#Example 3:
#
#Input: piles = [30,11,23,4,20], h = 6
#Output: 23
#
#
#
#Constraints:
#
#    1 <= piles.length <= 104
#    piles.length <= h <= 109
#    1 <= piles[i] <= 109
#
#

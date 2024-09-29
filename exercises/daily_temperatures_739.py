from typing import List
# Original Solution I came up with (kinda ugly, but still O(n) )
# class Solution:
#     def dailyTemperatures(temps: List[int]) -> List[int]:
#         stack = [(temps[-1], len(temps) - 1)]
#         ans = [0 for i in range(len(temps))]
#
#         for x in range(len(temps) - 2, -1, -1):
#             temp = temps[x]
#             while stack:
#                 next, i = stack[-1]
#                 if next > temp:
#                     ans[x] = i - x
#                     break
#                 stack.pop()
#             stack.append((temp, x))
#         return ans

# Most optimal Solution
class Solution:
    def dailyTemperatures(self, temps):
        results = [0 for x in range(len(temps))]
        stack = []
        for i, temp in enumerate(temps):
            while stack and temps[stack[-1]] < temp:
                index = stack.pop()
                results[index] = i - index
            stack.append(i)

        return results

# Other solution
# class Solution:
#     def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
#         res = [0] * len(temperatures)
#         stack = []     # pair: [temp, index]
#         for x, t in enumerate(temperatures):
#             while stack and t > stack[-1][0]:
#                 _, i = stack.pop()
#                 res[i] = x - i
#             stack.append((t, x))
#         return res

# Instructions:
    # For a given array of temperatures return an array that represents how many days a
    # certain temperature temp[i] will take to find a day which is hotter for all temperatures
# Peruse Examples 
#   Examples look very standard no hard curves  
# Exceptions:
#   All temperatures go down continuously
# Note constrains:
#   Constraints are very reasonable

# Thought Process: 
#   Travel the array backwards and pop all temps until you find a hotter temperature
#   And when you find one record how long it took and store it, if no such value was
#   Found record zero, and then push the temp into the stack 
# 
# NOTE: Problem Description
# 739. Daily Temperatures
# Given an array of integers temperatures represents the daily temperatures, return an array 
# answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
# If there is no future day for which this is possible, keep answer[i] == 0 instead.
#
#
#
# Example 1:
#
# Input: temperatures = [73,74,75,71,69,72,76,73]
# Output: [1,1,4,2,1,1,0,0]
#
# Example 2:
#
# Input: temperatures = [30,40,50,60]
# Output: [1,1,1,0]
#
# Example 3:
#
# Input: temperatures = [30,60,90]
# Output: [1,1,0]
#
#
#
# Constraints:
#
#     1 <= temperatures.length <= 105
#     30 <= temperatures[i] <= 100



from typing import List

# Better Solution
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n = len(matrix[0]) 
        m = len(matrix) 
        l = 0
        r = n * m - 1
        while l <= r:
            mid = l + (r - l) // 2
            # mid_row, mid_col = divmod(mid, n)
            midValue = matrix[mid // n][mid % n]
            if target < midValue:
                r = mid - 1
            elif target > midValue:
                l = mid + 1
            else:
                return True
        return False


# My original solution
# class Solution:
#     def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
#         n = len(matrix)
#         m = len(matrix[0])
#         search_row = 0
#         t = 0
#         b = n - 1
#         while (t <= b):
#             middle_row = t + (b - t) // 2
#             start = matrix[middle_row][0]
#             end = matrix[middle_row][m - 1]
#             if target < start:
#                 b = middle_row - 1
#             elif target > end:
#                 t = middle_row + 1
#
#             else:
#                 search_row = middle_row
#                 break
#         l = 0
#         r = m - 1
#         while (l <= r):
#             middle = l + (r - l) // 2
#             curr_val = matrix[search_row][middle]
#             if target < curr_val:
#                 r = middle - 1
#             elif target > curr_val:
#                 l = middle + 1
#             else:
#                 return True
#
#         return False
#
#  INSTRUCTIONS
# 74. Search a 2D Matrix
# You are given an m x n integer matrix matrix with the following two properties:
#
#     Each row is sorted in non-decreasing order.
#     The first integer of each row is greater than the last integer of the previous row.
#
# Given an integer target, return true if target is in matrix or false otherwise.
#
# You must write a solution in O(log(m * n)) time complexity.
#
#
#
# Example 1:
#
# Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
# Output: true
#
# Example 2:
#
# Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
# Output: false
#
#
#
# Constraints:
#
#     m == matrix.length
#     n == matrix[i].length
#     1 <= m, n <= 100
#     -104 <= matrix[i][j], target <= 104
#


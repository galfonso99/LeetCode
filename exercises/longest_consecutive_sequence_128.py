from typing import List
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        Set = set(nums)
        Max = 0
        for num in Set:
            if (num - 1) not in Set:
                i = num + 1
                while i in Set:
                    i += 1
                Max = max(Max, i - num)
        return Max
    
    # def longestConsecutive(self, nums):
    #     nums = set(nums)
    #     best = 0
    #     for x in nums:
    #         if x - 1 not in nums:
    #             y = x + 1
    #             while y in nums:
    #                 y += 1
    #             best = max(best, y - x)
    #     return best
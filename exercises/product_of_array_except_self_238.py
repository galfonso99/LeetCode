from typing import List
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [0 for _ in range(len(nums))]
        left = 1
        for i in range(len(res)):
            res[i] = left
            left *= nums[i]
        right = 1
        for i in range(len(res)-1, -1, -1):
            res[i] *= right
            right *= nums[i]
        return res

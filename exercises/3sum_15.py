from typing import List
class Solution:
    def threeSum (self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        for i, val in enumerate(nums):
            if i > 0 and val == nums[i - 1]: continue
            if val > 0: break
            
            l , r = i + 1, len(nums) - 1
            while l < r:
                diff = 0 - (nums[l] + nums[r])
                if val < diff:
                    l += 1
                elif val > diff:
                    r -= 1
                else:
                    new_list = [val, nums[l], nums[r]]
                    res.append(new_list)
                    l += 1
                    r -= 1
                    while l < len(nums) and nums[l] == nums[l-1]:
                        l += 1
        return res

from typing import List

# Original solution
class Solution:
    def maxArea(self, h: List[int]) -> int:
        n = 0
        m = len(h) - 1
        Max = 0
        while n < m:
            area = min(h[n], h[m]) * (m - n)
            if h[n] <= h[m]:
                n += 1
            else:
                m -= 1
            Max = max(Max, area)
        return Max 

# Faster Solution using the same idea
# class Solution:
#     def maxArea(self, h: List[int]) -> int:
#         area, l, r = 0, 0, len(h)-1
#         while l<r:
#             if h[l]<h[r]:
#                 area = max(area,h[l]*(r-l))
#                 l+=1
#             elif h[r]<h[l]:
#                 area = max(area,h[r]*(r-l))
#                 r-=1
#             else:
#                 area = max(area,h[r]*(r-l))
#                 r-=1
#                 l+=1
#         return area

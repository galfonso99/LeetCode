# MinHeap Solution
from heapq import heapreplace, heapify
from typing import List
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # Min heap approach - O(n log k)
        heap = nums[:k]
        heapify(heap)  # O(k)
        
        for num in nums[k:]:
            if num > heap[0]:
                heapreplace(heap, num)
        
        return heap[0]

# Array Solutions
# class Solution:
#     def findKthLargest(self, nums: List[int], k: int) -> int:
#         # Your counting sort approach
#         count = [0] * 20002  # Using list instead of numpy
#         for num in nums:
#             count[num + 10000] += 1
#         for i in range(len(count) - 1, -1, -1):
#             k -= count[i]
#             if k <= 0:
#                 return i - 10000
#         return 0

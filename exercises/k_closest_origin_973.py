import heapq
from typing import List

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heap = []
        for i, (x, y) in enumerate(points[:k]):
            dist = x*x + y*y
            heapq.heappush(heap, (-dist, i))
        for i, (x, y) in enumerate(points[k:], k):
            dist = x*x + y*y
            if -dist > heap[0][0]:
                heapq.heapreplace(heap, (-dist, i))
                
        return [points[i] for _, i in heap]

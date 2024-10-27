from typing import List
import heapq

class MaxHeap:
    def __init__(self):
        self.data = []

    def top(self):
        return -self.data[0]

    def push(self, val):
        heapq.heappush(self.data, -val)

    def pop(self):
        return -heapq.heappop(self.data)

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = MaxHeap()
        for stone in stones:
            heap.push(stone)
        while len(heap.data) > 1:
            max = heap.pop()
            max2 = heap.pop()
            diff = max - max2
            if diff != 0: heap.push(diff)
        return heap.top() if len(heap.data) > 0 else 0


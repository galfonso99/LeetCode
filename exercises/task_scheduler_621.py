from heapq import heappush, heappop
from typing import List

# MaxHeap
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = [0] * 27
        maxHeap = []
        for ch in tasks:
            freq[ord(ch) - ord("A")] += 1
        for f in freq:
            if f > 0: heappush(maxHeap, -f)
        time = 0
        while len(maxHeap) > 0:
            addBack = []
            for _ in range(n+1):
                if len(maxHeap) > 0:
                    count = -heappop(maxHeap)
                    count -= 1
                    if count > 0:
                        addBack.append(count)
                time += 1
                if len(maxHeap) == 0 and len(addBack) == 0:
                    break
            for count in addBack:
                heappush(maxHeap, -count)
        return time

# Math Solution
# class Solution:
#     def leastInterval(self, tasks: List[str], n: int) -> int:
#         freq = [0] * 27
#         for ch in tasks:
#             freq[ord(ch) - ord("A")] += 1
#         maxFreq, maxCount = 0, 0
#         for f in freq:
#             if f == 0: continue
#             if f > maxFreq:
#                 maxFreq = f
#                 maxCount = 1
#             elif f == maxFreq:
#                 maxCount += 1
#         maxTasksCycles = maxFreq - 1
#         gapsBetweenMaxTasks = n - (maxCount - 1)
#         emptySlots = maxTasksCycles * gapsBetweenMaxTasks
#         availableTasks = len(tasks) - (maxFreq * maxCount)
#         idleSlots = max(0, emptySlots - availableTasks)
#         return len(tasks) + idleSlots



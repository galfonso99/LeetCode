from typing import List
# from collections import defaultdict

# NeetCode Solution
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}
        freq = [[] for _ in range(len(nums) + 1)]

        for n in nums:
            count[n] = 1 + count.get(n, 0)
        for n, c in count.items():
            freq[c].append(n)

        res = []
        for i in range(len(freq) - 1, 0, -1):
            for n in freq[i]:
                res.append(n)
                if len(res) == k:
                    return res
        return []

# More Pythonic Solution (than my original solution)
# def topKFrequent(self, nums: List[int], k: int) -> List[int]:
#     freq_map = defaultdict(int)
#     for num in nums:
#         freq_map[num] += 1
#
#     max_freq = max(freq_map.values(), default=0)
#     bucket = [[] for _ in range(max_freq + 1)]
#
#     for num, freq in freq_map.items():
#         bucket[freq].append(num)
#     ans = []
#
#     for i in range(max_freq, 0, -1):
#         if bucket[i]:
#             ans.extend(bucket[i])
#         if len(ans) >= k:
#             break
#
#     return ans[:k]

# My solution that came from a try at a language agnostic solution in Python (not very Pythonic)
# class Solution:
#     def topKFrequent(self, nums: List[int], n: int) -> List[int]:
#         map = defaultdict(int)
#         counts = [[]] * (len(nums) + 1)
#         res = []
#         for num in nums:
#             map[num] += 1
#         for k, v in map.items():
#             if len(counts[v]) == 0:
#                 counts[v] = [k]
#             else:
#                 counts[v].append(k)
#         counter = 0
#         for i in range(len(counts) - 1, -1, -1):
#             if counter >= n:
#                 break
#             if len(counts[i]) == 0:
#                 continue
#
#             for j in range(len(counts[i])):
#                 if counter >= n:
#                     break
#                 res.append(counts[i][j])
#                 counter += 1
#         return res
        
# Collect the frequency into the map
# Loop over map and using freq as index insert it into a list where in that
# index you will store a list of every value with that same frequency
# Loop over the array backwards // range (10, 0, -1)
# for each k pick one from the back

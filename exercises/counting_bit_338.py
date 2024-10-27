from typing import List
class Solution:
    def countBits(self, n: int) -> List[int]:
        bit = 0
        arr = [0] * (n + 1)
        for i in range(1, n+1):
            square = 1 << bit
            if i == (square << 1):
                bit += 1
                square <<= 1
            diff = i - square
            arr[i] = arr[diff] + 1
        return arr


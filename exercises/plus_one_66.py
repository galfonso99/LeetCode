# This solution has been optimized as few local variables as possible while still
# having top performance

from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        n = len(digits)
        for i in range(n-1, -1, -1):
            if digits[i] == 9: digits[i] = 0
            else:
                digits[i] += 1
                break
        if digits[0] == 0:
            digits = [0] * (n+1)
            digits[0] = 1
        return digits

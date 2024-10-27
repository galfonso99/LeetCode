# More Straightforward Solution
class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        for _ in range(32):
            res <<= 1
            res |= (n & 1)
            n >>= 1
        return res

#Original solution left here for transparency
class Solution:
    def reverseBits(self, n: int) -> int:
        for i in range(16):
            left_bit = (n >> (31 - i)) & 1
            right_bit = (n >> i) & 1
            if left_bit != right_bit:
                n = n ^ (1 << (31 - i))
                n = n ^ (1 << i)
        return n




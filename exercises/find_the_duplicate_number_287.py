from typing import List

class Solution:
    def findDuplicate(self, A: List[int]) -> int:
        slow = A[A[0]] # slow starts at A[0] and then takes one step A[slow] == A[A[0]]
        fast = A[A[A[0]]]  # fast also starts at A[0] then takes 2 steps so we have A[A[A[0]]]
        while slow != fast:
            slow = A[slow]
            fast = A[A[fast]]
        slow = A[0]
        while slow != fast:
            slow = A[slow]
            fast = A[fast]
        return slow

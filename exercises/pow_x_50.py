class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            n = -n
            x = 1 / x
        return rec(x,n)

def rec(x: float, n: int) -> float:
    if n == 0: return 1
    return rec(x * x, n // 2) if n % 2 == 0 else x * rec(x * x, n // 2)

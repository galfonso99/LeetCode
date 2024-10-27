# Do one where you precompute numbers 1 through 9
class Solution:
    def isHappy(self, n: int) -> bool:
        while n > 9:
            sum = 0
            while n > 0:
                digit = n % 10
                sum += digit * digit
                n //= 10
            n = sum
        return n == 1 or n == 7


        
# Do one with Floyd's
# class Solution:
#     def isHappy(self, n: int) -> bool:
#         slow = n
#         fast = n
#         while True:
#             slow = square(slow)
#             fast = square(square(fast))
#             if slow == fast:
#                 break
#         return slow == 1 or slow == 7
#
# def square(n):
#     sum = 0
#     while n > 0:
#         digit = n % 10
#         sum += digit * digit
#         n //= 10
#     return sum

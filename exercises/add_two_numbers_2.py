from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        node = dummy
        carry = 0
        while l1 or l2:
            sum = carry
            if l1: sum += l1.val
            if l2: sum += l2.val
            carry = 1 if sum > 9 else 0
            sum %= 10
            node.next = ListNode(sum)
            node = node.next
            if l1: l1 = l1.next
            if l2: l2 = l2.next
        if carry > 0: node.next = ListNode(1)
        return dummy.next

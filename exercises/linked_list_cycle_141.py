from typing import Optional
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# My solution | The error occurs bc the lsp cant know that slow wont ever by None
class Solution:
    def hasCycle(self, slow: Optional['ListNode']) -> bool:
        fast = slow
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast: return True
        return False

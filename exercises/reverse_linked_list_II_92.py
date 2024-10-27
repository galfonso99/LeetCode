class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head
        pre = dummy
        for i in range(left - 1):
            pre = pre.next
        start = pre.next
        next = start.next
        for i in range(right - left):
            start.next = next.next
            next.next = pre.next;
            pre.next = next;
            next = start.next
        return dummy.next






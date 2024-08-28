from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 is None:
            return list2
        if list2 is None:
            return list1
        dummy = ListNode()
        head = dummy
        while list1 is not None and list2 is not None:
            if list1.val <= list2.val:
                head.next = list1
                list1 = list1.next
                head = head.next
            else:
                head.next = list2
                list2 = list2.next
                head = head.next
        if list1 is None:
            head.next = list2
        if list2 is None:
            head.next = list1
        res = dummy.next
        return res

# class Solution:
#     def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
#         if list1 is None:
#             return list2
#         if list2 is None:
#             return list1
#
#         if list1.val <= list2.val:
#             list1.next = Solution().mergeTwoLists(list1.next, list2)
#             return list1
#         else:
#             list2.next = Solution().mergeTwoLists(list1, list2.next)
#             return list2



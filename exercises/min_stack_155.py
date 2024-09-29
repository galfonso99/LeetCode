from __future__ import annotations
from typing import Optional
class Node:
    def __init__(self, val: int, min: int, next: Optional['Node']):
        self.val = val
        self.min = min
        self.next = next

class MinStack:
    def __init__(self):
        self.head: Optional[Node] = None
    def push(self, val: int) -> None:
        Min = val if not self.head or self.head.min > val else self.head.min
        self.head = Node(val, Min, self.head)
    def pop(self) -> None:
        if not self.head: return
        self.head = self.head.next
    def top(self) -> int:
        if not self.head: return 0
        return self.head.val
    def getMin(self) -> int:
        if not self.head: return 0
        return self.head.min 

# You could also solve it by keeping a List of Values and a List of minimums which
# Doesnt require a custom Node class but requires 2 Lists and more book-keeping



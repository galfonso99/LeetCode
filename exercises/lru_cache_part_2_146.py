from typing import Optional
class Node:
    def __init__(self, key: int, value: int) -> None:
        self.key = key
        self.value = value
        self.next: Optional[Node] = None
        self.prev: Optional[Node] = None

class LRUCache:
    def __init__(self, capacity: int) -> None:
        self.capacity = capacity
        self.count = 0
        self.head: Optional[Node] = Node(-1, -1)
        self.tail: Optional[Node] = Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.map = {}
    def get (self, key: int) -> int:
        node = self.map.get(key)
        if node is None:
            return -1
        self.update(node)
        return node.value

    def put (self, key: int, value: int) -> None:
        node = self.map.get(key)
        if node is not None:
            node.value = value
            self.update(node)
        else:
            new_node = Node(key, value)
            self.add(new_node)
            self.count+=1
            self.map[key] = new_node
        if self.count > self.capacity:
            self.map.pop(self.tail.prev.key)
            self.remove(self.tail.prev)
            self.count -= 1
    def update (self, node: Node):
        self.remove(node)
        self.add(node)
    def add (self, node: Node):
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node
    def remove (self, node: Node):
        node.next.prev = node.prev
        node.prev.next = node.next



class Node:
    def __init__(self, value) -> None:
        self.value = value
        self.next = None
        self.prev = None

class LinkedList:
    def __init__(self, size) -> None:
        self.size = size
        self.head = None
        self.tail = None

class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.list = LinkedList(0)
        self.lookup = {}
        self.reverseLookup = {}


    def get(self, key: int) -> int:
        if key not in self.lookup:
            return -1        
        node = self.lookup[key]
        self.moveFront(node)
        # for key, value in self.lookup.items():
        #     print(f"{key}: {value.value}", end=' <> ')
        # print("\n")
        return node.value
        

    def put(self, key: int, value: int) -> None:
        if key in self.lookup:
            node = self.lookup[key]
            node.value = value
            self.moveFront(node)
        elif self.list.size == self.capacity:
            self.insertFront(key, value)
            self.deleteLast()
        else:
            self.insertFront(key, value)
        # for key, value in self.lookup.items():
        #     print(f"{key}: {value.value}", end=' <> ')
        # print("\n")

    def moveFront(self, node):
        if self.list.size < 2:
            return
        if self.list.head == node:
            return
        if node.next is not None:
            node.next.prev = node.prev
        if node.prev is not None:
            node.prev.next = node.next

        if node is self.list.tail:
            self.list.tail = self.list.tail.prev
        node.prev = None
        node.next = self.list.head
        self.list.head.prev = node
        self.list.head = node
        

    def insertFront (self, key, value):
        new_node = Node(value)
        new_node.next = self.list.head
        if self.list.head is None:
            self.list.head = new_node
            self.list.tail = new_node
        else:
            self.list.head.prev = new_node
            self.list.head = new_node
        if self.list.tail is not None and self.list.tail.prev is None:
            self.list.tail.prev = new_node
        self.list.size += 1
        self.lookup[key] = new_node
        self.reverseLookup[new_node] = key

    def deleteLast(self) -> bool:
        if self.list.size == 0:
            return False

        key = self.reverseLookup[self.list.tail]
        del self.lookup[key]
        del self.reverseLookup[self.list.tail]
        if self.list.tail is not None and self.list.tail.prev is not None:
            self.list.tail.prev.next = None
            self.list.tail = self.list.tail.prev
        else:
            self.list.head = None
            self.list.tail = None
        self.list.size -= 1
        
        return True


package main

type Node struct {
    val int
    next *Node
    prev *Node
}

type LinkedList struct {
    size int
    head *Node
    tail *Node
}

type LRUCache struct {
    capacity int
    list LinkedList
    lookup map[int]*Node
    reverseLookup map[*Node]int
}


func Constructor(capacity int) LRUCache {
    return LRUCache {capacity: capacity, list: LinkedList{size: 0}, 
        lookup: make(map[int]*Node), reverseLookup: make(map[*Node]int)}
}


func (this *LRUCache) Get(key int) int {
    node, ok := this.lookup[key]
    if !ok {
        return -1
    }
    this.MoveFront(node)
    return node.val
}

func (this *LRUCache) Put(key int, value int)  {
    node, ok := this.lookup[key]
    if ok {
        node.val = value
        this.MoveFront(node)
    } else if this.list.size == this.capacity {
        this.InsertFront(key, value)
        this.DeleteLast()
    } else {
        this.InsertFront(key, value)
    }
}

func (this *LRUCache) MoveFront(node *Node)  {
    if this.list.size < 2 {
        return
    }
    if this.list.head == node {
        return
    }
    if node.next != nil {
        node.next.prev = node.prev
    }
    if node.prev != nil {
        node.prev.next = node.next
    }
    if node == this.list.tail {
        this.list.tail = this.list.tail.prev
    }
    node.prev = nil
    node.next = this.list.head
    this.list.head.prev = node
    this.list.head = node
}

func (this *LRUCache) InsertFront(key int, value int) {
    node := &Node {val: value}
    node.next = this.list.head
    if this.list.head == nil {
        this.list.head = node
        this.list.tail = node
    } else {
        this.list.head.prev = node
        this.list.head = node
    }
    if this.list.tail != nil && this.list.tail.prev == nil {
        this.list.tail.prev = node
    }
    this.list.size++
    this.lookup[key] = node
    this.reverseLookup[node] = key
}

func (this *LRUCache) DeleteLast() bool {
    if this.list.size == 0 {
        return false
    }
    key := this.reverseLookup[this.list.tail]
    delete(this.lookup, key)
    delete(this.reverseLookup, this.list.tail)
    if this.list.tail != nil && this.list.tail.prev != nil {
        this.list.tail.prev.next = nil
        this.list.tail = this.list.tail.prev
    } else {
        this.list.head = nil
        this.list.tail = nil
    }
    this.list.size--
    return true
}


package main

import "container/list"

// Definition for singly-linked list.
// type ListNode struct {
//     Val int
//     Next *ListNode
// }


func reverseList(head *ListNode) *ListNode {
    var prev *ListNode = nil
    for head != nil {
        next := head.Next
        head.Next = prev
        prev = head
        head = next
    }
    return prev
}

func rev (head *list.Element) *list.Element {
    new := list.New()
    prev := new.Front()
    for head != nil {
        next := head.Next()
        tempNext := head.Next()
        *tempNext = *prev
        prev = head
        head = next
        // _ = temp
    }
    return prev
}


package main

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    if l1 == nil {
        return l2
    }
    if l2 == nil {
        return l1
    }

    dummy := ListNode {Val: 0, Next: nil}
    head := &dummy
    for l1 != nil && l2 != nil {
        if l1.Val <= l2.Val {
            head.Next = l1
            l1 = l1.Next
            head = head.Next
        } else {
            head.Next = l2
            l2 = l2.Next
            head = head.Next
        }
    }
    if l1 == nil {
        head.Next = l2
    }
    if l2 == nil {
        head.Next = l1
    }
    res := dummy.Next
    return res
}

// func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    // if list1 == nil {
    //     return list2
    // }
    // if list2 == nil {
    //     return list1
    // }
    //
    // if list1.Val <= list2.Val {
    //     list1.Next = mergeTwoLists(list1.Next, list2)
    //     return list1
    // } else {
    //     list2.Next = mergeTwoLists(list1, list2.Next)
    //     return list2
    // }

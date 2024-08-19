 // * Definition for singly-linked list.

 package add_two;

  type ListNode struct {
      Val int
      Next *ListNode
  }

 func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    carry, dummy := 0, new(ListNode)
    node := dummy; 
    for l1 != nil || l2 != nil || carry > 0 {
        if l1 != nil {
            carry += l1.Val
            l1 = l1.Next
        }
        if l2 != nil {
            carry += l2.Val
            l2 = l2.Next
        }
        node.Next = &ListNode{carry % 10, nil}
        carry /= 10
        node = node.Next
    }
    return dummy.Next
}

// First attempt, very bad code. Me inexperienced at Go
//
// func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
//     l3 := new(ListNode)
//     head := l3
//     carry := 0
//     val1, val2 := 0, 0
//     for l2 != nil || l1 != nil {
//       if l1 != nil {val1 = l1.Val; l1 = l1.Next} else {val1 = 0}
//       if l2 != nil {val2 = l2.Val; l2 = l2.Next} else {val2 = 0}
//       sum := val1 + val2 + carry
//       l3.Next = &ListNode {Val: sum % 10, Next: nil}
//       if sum > 9 { carry = 1} else { carry = 0}
//       l3 = l3.Next
//     }
//     if carry == 1 {
//       l3.Next = &ListNode {Val: 1, Next: nil}
//     }
//     return head.Next
// }


func removeNthFromEnd(head *ListNode, n int) *ListNode {
  dummy := &ListNode{-1, head}
  front, back := dummy, dummy

  for front.Next != nil {
    if n <= 0 {
      back = back.Next
    }
    n -= 1
    front = front.Next
  }
  back.Next = back.Next.Next
  return dummy.Next
}

// func removeNthFromEnd(head *ListNode, n int) *ListNode {
//     count, node = 0, head
//     for node != nil {
//       count += 1
//       node = node.Next
//     }
//     index := count - n + 1
//     count = 0
//     for node != nil {
//       if node == index - 1 {
//         node.Next = node.Next.Next
//         break
//       }
//       count += 1
//       node = node.Next
//     }
// }

// 1,2
//
// count = 0, idx = 0
// 0 , 1, 2
// 
// size = 10, index from back = 9
//
//
// I could do fast and slow pointers to figure out the length and then if the index is in the first half I start from the beginning and if its on
// the second half I start from the middle that I got from the 2 pointers approach

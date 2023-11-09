**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    // Do not use Strings
    l3 := ListNode {Val: 1; Next: nil}
    l4 := list.Next
    carry := false
    for l1.Val != nil && l2.Val != nil {
      l3.Val = (l1.Val + l2.Val) % 10
      if l1.Val + l2.Val > 9 {
        carry = true
      }
    }
    l3
}

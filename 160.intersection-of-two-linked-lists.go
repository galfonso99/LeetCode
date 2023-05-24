/*
 * @lc app=leetcode id=160 lang=golang
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getIntersectionNode(headA, headB *ListNode) *ListNode {
    a, b := headA, headB
    for a != b {
        if a != nil { a = a.Next } else { a = headB }
        if b != nil { b = b.Next } else { b = headA }
    }
    return a
}


// @lc code=end

/*
arr1 := make([]*ListNode,0)
    arr2 := make([]*ListNode,0)
	nodeA := headA
	nodeB := headB
	for nodeA != nil || nodeB != nil {
		if nodeA != nil {
			if contains(arr2, nodeA) {
				return nodeA;
			}
			arr1 = append(arr1,nodeA)
			nodeA = nodeA.Next
		}
		if nodeB != nil {
			if contains(arr1, nodeB) {
				return nodeB;
			}
			arr2 = append(arr2,nodeB)
			nodeB = nodeB.Next
		}
	}
	return nil
*/


/*
 * @lc app=leetcode id=141 lang=golang
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */



func hasCycle(head *ListNode) bool {
	if head == nil {return false;}
    slow := head;
	fast := head.Next;
	for slow != fast {
		if fast == nil || fast.Next == nil {
			return false;
		}
		slow = slow.Next;
		fast = fast.Next.Next;
	}
	return true;

}
// @lc code=end


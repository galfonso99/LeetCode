package main

/*
 * @lc app=leetcode id=234 lang=golang
 *
 * [234] Palindrome Linked List
 */

// @lc code=start

type ListNode struct {
     Val int
     Next *ListNode
 }

func isPalindrome(head *ListNode) bool {
    slow := head
	fast := head
	var rev *ListNode = nil

	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slowNext := slow.Next
		slow.Next = rev
		rev = slow
		slow = slowNext
	}

	if fast != nil {
		slow = slow.Next
	}
	for rev != nil {
		if rev.Val != slow.Val {
			return false;
		}
		slow = slow.Next
		rev = rev.Next 
	}
	return true
}
// @lc code=end


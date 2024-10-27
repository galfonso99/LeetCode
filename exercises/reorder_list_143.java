class Solution {
    public void reorderList(ListNode head) {
		var slow = head;
		var fast = head;
		var start = head;
		// Traverse to second half of the list
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		var half = fast.next;
		fast.next = null;
		// Reverse second half
		ListNode prev = null;
		while ( half != null ) {
			var next = half.next;
			half.next = prev;
			prev = half;
			half.next = next;
		}
		var reversed = prev;
		// Interleave the two halves of the list
		while ( reversed != null ) {
			var next = reversed.next;
			var start_next = start.next;
			start.next = reversed;
			start.next.next = start_next;
			start = start.next.next;
			reversed.next = next;
		}
    }
}

//Different way to interleave the two halves of the list
//while ( reversed != null ) {
//	var next = start.next;
//	start.next = reversed;
//	start = start.next;
//	reversed = next;
//}

/*
143. Reorder List
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

 

Constraints:

    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000

*/

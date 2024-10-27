// Better soluiont found online
class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null) return null;
		ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
		dummy.next = head;
		ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
		for(int i = 0; i<m-1; i++) pre = pre.next;
		ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
		ListNode nextNode = start.next; // a pointer to a node that will be reversed
		for(int i = 0; i < n - m; i++) {
			start.next = nextNode.next; 
			nextNode.next = pre.next; 
			pre.next = nextNode; 
			nextNode = start.next; 
		}
		return dummy.next;
	}
}

// Original messy solution
//class Solution {
//	public ListNode reverseBetween(ListNode head, int left, int right) {
//		ListNode dummy = new ListNode(-1);
//		dummy.next = head;
//		ListNode before_start = dummy;
//		ListNode end = dummy;
//		var node = head;
//		for (int i = 1; node != null; i++) {
//			if (i == left - 1) before_start = node;
//			if (i == right) end = node;
//			node = node.next;
//		}
//		var after_end = end.next;
//		end.next = null;
//		var start = before_start.next;
//		var start_copy = start;
//		ListNode prev = null;
//		while (start != null) {
//			var next = start.next;
//			start.next = prev;
//			prev = start;
//			start = next;
//		}
//		start_copy.next = after_end;
//		before_start.next = prev;
//		return dummy.next;
//    }
//
//}





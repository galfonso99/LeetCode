// Better solution with only one loop
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        var node = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            var sum = carry;
            if (l1 != null) sum += l1.val;
            if (l2 != null) sum += l2.val;
            carry = sum > 9 ? 1 : 0;
            sum %= 10;
            node.next = new ListNode(sum);
            node = node.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) node.next = new ListNode(1);
        return dummy.next;
    }
}
// Solve this without reversing the list
// Read curr node from l1 and l2 sum them, get the answer
// if answer is over 9 set the carry to 1
// change the sum to the modulo of sum and 10
// create a new Node with the sum value and add it to the front of the answer list
// Now move the two lists forward

// Original solution (sloppy) with two loops cause I just wanted to see if the logic was logiking
//class Solution {
//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		ListNode dummy = new ListNode(-1);
//		var node = dummy;
//		ListNode res = null;
//		int carry = 0;
//		while (l1 != null && l2 != null) {
//			var sum = l1.val + l2.val + carry;
//			carry = sum > 9 ? 1 : 0;
//			sum %= 10;
//			node.next = new ListNode(sum);
//			node = node.next;
//			l1 = l1.next;
//			l2 = l2.next;
//		}
//		if (l1 != null || l2 != null) {
//			var curr = l2 == null ? l1 : l2;
//			while (curr != null) {
//				var sum = curr.val + carry;
//				carry = sum > 9 ? 1 : 0;
//				sum %= 10;
//				node.next = new ListNode(sum);
//				node = node.next;
//				curr = curr.next;
//			}
//		}
//		if (carry > 0) node.next = new ListNode(1);
//		return dummy.next;
//	}
//}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// Optimal solution doing one pass [MINE]
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
		var slow = head;
		var fast = head;
        // Traverse fast pointer n steps
		while (n > 0) {
			fast = fast.next;
            n--;
		}
        // If fast got to the end then remove the first element
        if (fast == null) return head.next;
        // Move fast pointer one more step so that slow ends up at the element just before the element to remove
        fast = fast.next;
        // Now traverse the fast pointer ultil the end so that slow pointer ends up in the right place (x - 1)
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
        // Now point the previous's next to the element after the target element, so now target element is removed
		slow.next = slow.next.next;
		return head;
    }
}
// Even more optimal solution found online
public ListNode removeNthFromEnd(ListNode head, int n) {
    
    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head;
    
    //Move fast in front so that the gap between slow and fast becomes n
    for(int i=1; i<=n+1; i++)   {
        fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while(fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
}

// Original Naive solution
//class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//		int count = 0;
//		var start = head;
//		while (start != null && start.next != null) {
//			count += 2;
//			start = start.next.next;
//		}
//		if (start != null) count += 1;
//		var front_index = count - n - 1;
//		int i = 0;
//		var copy = head;
//		while (i < front_index) {
//			copy = copy.next;
//			i++;
//		}
//		copy.next = copy.next.next;
//		return head;
//    }
//}


//19. Remove Nth Node From End of List
//
//Given the head of a linked list, remove the nth node from the end of the list and return its head.
//
//
//
//Example 1:
//
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//
//Example 2:
//
//Input: head = [1], n = 1
//Output: []
//
//Example 3:
//
//Input: head = [1,2], n = 1
//Output: [1]
//
//
//
//Constraints:
//
//    The number of nodes in the list is sz.
//    1 <= sz <= 30
//    0 <= Node.val <= 100
//    1 <= n <= sz
//
//
//
//Follow up: Could you do this in one pass?
//

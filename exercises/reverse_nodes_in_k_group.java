// Original Solution (Fast)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head), prev = dummy;
        while (prev != null) {
            var curr = prev;
            for (int i = 0; i < k && curr != null; i++) curr = curr.next;
            if (curr == null) break;
            var next = curr.next;
            var tail = prev.next;
            prev.next = reverse(prev.next, k);
            tail.next = next;
            prev = tail;
        }
        return dummy.next;
    }
    
    ListNode reverse(ListNode node, int k) {
        ListNode prev = null;
        while (k > 0) {
            var next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            k--;
        }
        return prev;
    }
}

// Recursion
// public class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         ListNode cur = head;
//         int group = 0;
//         while (cur != null && group < k) { 
//             cur = cur.next;
//             group++;
//         }
//
//         if (group == k) { 
//             cur = reverseKGroup(cur, k); 
//             while (group-- > 0) { 
//                 ListNode tmp = head.next; 
//                 head.next = cur; 
//                 cur = head; 
//                 head = tmp; 
//             }
//             head = cur;
//         }
//         return head;
//     }
// }

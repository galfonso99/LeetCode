// Clever algorithm where you put each List into a heap then order the heap based on 
// the head value, then when you poll a list and it has more values then you simply
// put it back on the heap with its head cut off.
// This way the next smallest values across all lists is always one of the head values
// of the lists contained inside the heap

import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;

            node = node.next;
            if (node != null) {
                minHeap.offer(node);
            }
        }
        return res.next;
    }
}

// Divide and Conquer (Fast)
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists == null || lists.length == 0) {
//             return null;
//         }
//         return divide(lists, 0, lists.length - 1);
//     }
//
//     private ListNode divide(ListNode[] lists, int l, int r) {
//         if (l > r) { 
//             return null;
//         }
//         if (l == r) {
//             return lists[l];
//         }
//
//         int mid = l + (r - l) / 2; 
//         ListNode left = divide(lists, l, mid);
//         ListNode right = divide(lists, mid + 1, r);
//
//         return conquer(left, right);
//     }
//
//     private ListNode conquer(ListNode l1, ListNode l2) {
//         ListNode dummy = new ListNode(0);
//         ListNode curr = dummy;
//
//         while (l1 != null && l2 != null) {
//             if (l1.val <= l2.val) {
//                 curr.next = l1;
//                 l1 = l1.next;
//             } else {
//                 curr.next = l2;
//                 l2 = l2.next;
//             }
//
//             curr = curr.next;
//         }
//
//         if (l1 != null) {
//             curr.next = l1;
//         } else {
//             curr.next = l2;
//         }
//
//         return dummy.next;
//     }
// }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Merge one by one (SLOW)
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists.length == 0) return null;
//
//         for (int i = 1; i < lists.length; i++) {
//             lists[i] = merge(lists[i], lists[i - 1]);
//         }
//         return lists[lists.length - 1];
//     }
//
//     private ListNode merge(ListNode l1, ListNode l2) {
//         ListNode dummy = new ListNode(0);
//         ListNode curr = dummy;
//
//         while (l1 != null && l2 != null) {
//             if (l1.val <= l2.val) {
//                 curr.next = l1;
//                 l1 = l1.next;
//             } else {
//                 curr.next = l2;
//                 l2 = l2.next;
//             }
//
//             curr = curr.next;
//         }
//
//         if (l1 != null) {
//             curr.next = l1;
//         } else {
//             curr.next = l2;
//         }
//
//         return dummy.next;
//     }
// }

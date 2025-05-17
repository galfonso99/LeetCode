// Clever algorithm where you put each List into a heap then order the heap based on 
// the head value, then when you poll a list and it has more values then you simply
// put it back on the heap with its head cut off.
// This way the next smallest values across all lists is always one of the head values
// of the lists contained inside the heap
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

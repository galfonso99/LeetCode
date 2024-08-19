import static java.lang.System.out;
// import java.util.*;
//                  
//
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class merge_sorted_lists_21 {
    public static void main(String[] args) {
        var sol = new Solution();
        var list = new ListNode(1);
        list.next = new ListNode(3);
        list.next.next = new ListNode(6);
        // var res = sol.reverseList(list);
        // out.printf("The result is %d %n", res.val);
    }
}

class Solution {
    public ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        var dummy = new ListNode(-1); 
        var head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            head.next = l2;
        }
        if (l2 == null) {
            head.next = l1;
        }
        var result = dummy.next;
        return result;

    }
    
		//   public ListNode mergeLists(ListNode l1, ListNode l2) {
		//       if(l1 == null) return l2;
		// if(l2 == null) return l1;
		// if(l1.val < l2.val){
		// 	l1.next = mergeLists(l1.next, l2);
		// 	return l1;
		// } else{
		// 	l2.next = mergeLists(l1, l2.next);
		// 	return l2;
		// }
		//   }

}


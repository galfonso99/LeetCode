// import static java.lang.System.out;
// import java.util.*;
//                  
//

public class merge_sorted_lists_21 {
    public static void main(String[] args) {
        // var sol = new Solution();
        // var list = new ListNode(1);
        // list.next = new ListNode(3);
        // list.next.next = new ListNode(6);
        // var res = sol.reverseList(list);
        // out.printf("The result is %d %n", res.val);
    }
}

class Solution_21 {
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
    

}

// Another way to solve it (maybe less elegant)
// Just keep list1 as an in order merged list and only swap when list2 is less than list1
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         if (list1 == null && list2 == null) return null;
//         if (list1 == null) return list2;
// 		if (list2 != null && list2.val < list1.val) {
// 			var temp = list1;
// 			list1 = list2;
// 			list2 = temp;
// 		}
// 		var dummy = new ListNode(-1, list1);
// 		while (list1 != null && list1.next != null && list2 != null) {
// 			if (list2.val < list1.next.val) {
// 				var temp = list1.next;
// 				list1.next = list2;
// 				list2 = temp;
// 			} 
// 			list1 = list1.next;
// 		}
// 		if (list2 != null && list1 != null) {
// 			list1.next = list2;
// 		}
// 		return dummy.next;
//     }
// }

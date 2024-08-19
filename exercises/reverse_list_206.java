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

public class reverse_list_206 {
    public static void main(String[] args) {
        var sol = new Solution();
        var list = new ListNode(1);
        list.next = new ListNode(3);
        list.next.next = new ListNode(6);
        var res = sol.reverseList(list);
        out.printf("The result is %d %n", res.val);
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        return rev(head, new ListNode());
    }
    ListNode rev (ListNode head, ListNode reversed) {
        if (head == null) {
            return reversed;
        }
        var prev = reversed;
        reversed = head;
        reversed.next = prev;
        head = head.next;
        return rev(head, reversed);

    }
}



/*
 * @lc app=leetcode id=234 lang=rust
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//   pub val: i32,
//   pub next: Option<Box<ListNode>>
// }
//
// impl ListNode {
//   #[inline]
//   fn new(val: i32) -> Self {
//     ListNode {
//       next: None,
//       val
//     }
//   }
// }
impl Solution {
    pub fn is_palindrome(mut head: Option<Box<ListNode>>) -> bool {
        let mut slow = head.as_ref();
        let mut fast = head.as_ref();
        let mut rev: Option<&Box<ListNode>> = None;
        while let Some(fast_node) = fast {
            if let Some(node) = slow {
                slow = node.next.as_ref();
                if fast_node.next.is_some() {
                    if rev.is_none() {
                        node.clone().next = None;
                    } else {
                        node.clone().next = Some(rev.unwrap().clone());
                    }
                    rev = Some(node);
                }
            }
            let tmp = fast_node.next.as_deref();
            if let Some(tmp) = tmp {
                fast = tmp.next.as_ref();
            }
        }
        println!("{slow:?} {fast:?} {rev:?}");
        if slow.is_none() {
            return true;
        }
        while let Some(rev_node) = rev {
            if let Some(slow_node) = slow {
                if rev_node.val != slow_node.val {
                    return false;
                }
                rev = rev_node.next.as_ref();
                slow = slow_node.next.as_ref();
            } else {
                return false;
            }
        }
        true
    }
}
// @lc code=end

// using a slow and fast pointer when fast ends slow is at half
// As you loop try to reverse the first half of the list
// Now compare the reversed first half with the original second half

// O(n + n/2) = O(n)

// let tail = n.next
// n.next = new_list
// new_list = n
// n = tail

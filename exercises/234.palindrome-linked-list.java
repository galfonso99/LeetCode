/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
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
public class Solution {
        public boolean isPalindrome(ListNode head) {
            // The list is never always 1 node or more (from constraints)
            ListNode slow = head;
            ListNode fast = head;
            ListNode rev = null;
            // Slowly reverse the slow pointer in place by making slow's tail equal
            // to prev which is the previously reversed sublist
            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                ListNode slowNext = slow.next;
                slow.next = rev;
                rev = slow;
                slow = slowNext;
            }
            //If number of elements is odd the list is now in the very center element
            // Need to move right once since center element is already equal to itself
            if(fast != null) {
                slow = slow.next;
            }
            //compare second half to reversed first half
            while(rev != null) {
                if(slow.val != rev.val) {
                    return false;
                }
                slow = slow.next;
                rev = rev.next;
            }
            return true;
            
        }
    }
// @lc code=end


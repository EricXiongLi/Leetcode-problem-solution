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
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // even total number
        ListNode flag;
        if (fast == null) {
            flag = reverse(slow);
        } else {
            flag = reverse(slow.next);
        }
        ListNode left = head, right = flag;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        //rember to reverse the list back
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head, cur = head.next, next = cur.next;
        head.next = null;
        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            if (next != null) {
            next = next.next;
            }
        }
        return prev;
    }
}

//tc: O(n)
//sc: O(1)
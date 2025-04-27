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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode p1 = dummy, p2 = dummy;

        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode prev = p2;
        while (p1 != null) {
            p1 = p1.next;
            prev = p2;
            p2 = p2.next; 
        }

        prev.next = p2.next;
        return dummy.next;
    }
}
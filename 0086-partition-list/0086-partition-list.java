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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-101), dummy2 = new ListNode(-101);
        ListNode p1 = dummy1, p2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                head = head.next;
                p1 = p1.next;
            } else {
                p2.next = head;
                head = head.next;
                p2 = p2.next;
            }
        }
        p1.next = dummy2.next;
        p2.next = null;
        return dummy1.next;
    }
}
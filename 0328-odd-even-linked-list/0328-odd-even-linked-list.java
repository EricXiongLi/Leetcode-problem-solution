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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddDummy = new ListNode(-1, head);
        ListNode evenDummy = new ListNode(-1, head.next);
        ListNode p1 = oddDummy.next;
        ListNode p2 = evenDummy.next;
        ListNode p1Next = (p1 == null || p1.next == null) ? null : p1.next.next;
        ListNode p2Next = (p2 == null || p2.next == null) ? null : p2.next.next;

        while (true) {
            if (p1Next != null) {
                p1.next = p1Next;
                p1 = p1Next;
                p1Next = (p1 == null || p1.next == null) ? null : p1.next.next;
            }

            if (p2Next != null) {
                p2.next = p2Next;
                p2 = p2Next;
                p2Next = (p2 == null || p2.next == null) ? null : p2.next.next;
            }

            if (p1Next == null && p2Next == null) {
                break;
            }
        }

        p1.next = evenDummy.next;
        p2.next = null;

        return oddDummy.next;
    }
}
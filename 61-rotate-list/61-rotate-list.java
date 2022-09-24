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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        ListNode dummy = new ListNode(0);
        int len = 1;
        
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        
        k = k % len;
        if (k == 0) {
            return head;
        }
        k = len - k;
        ListNode cur = head;
        for (int i = 1; i < k; i++) {
            cur = cur.next;
        }
        dummy.next = cur.next;
        tail.next = head;
        cur.next = null;
        return dummy.next;
    }
}
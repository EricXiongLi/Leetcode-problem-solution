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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int N = 0;
        while (cur != null) {
            N++;
            cur = cur.next;
        }
        int i = 1;
        while (i + k - 1 <= N) {
            head = reverseBetween(i, i + k - 1, head);
            i += k;
        }
        return head;
    }
    
    public ListNode reverseBetween(int left, int right, ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        int pos = 1;
        while (pos < left) {
            prev = cur;
            cur = cur.next;
            pos++;
        }
        ListNode leftP = prev;
        ListNode startP = cur;
        ListNode next = new ListNode();
        while (pos <= right) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            pos++;
        }
        leftP.next = prev;
        startP.next = cur;
        return dummy.next;
    }
}


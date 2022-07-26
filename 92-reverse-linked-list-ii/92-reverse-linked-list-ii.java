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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        ListNode next = new ListNode();
        
        
        int pos = 1;
        
        while (pos < left) {
            prev = cur;
            cur = cur.next;
            pos++;
        }
        
        ListNode startP = prev;
        ListNode leftP = cur;
        while (pos <= right) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            pos++;
        }
        
        startP.next = prev;
        leftP.next = cur;
        
        return dummy.next;
        //tc: O(n) sc: O(1)
        
    }
}
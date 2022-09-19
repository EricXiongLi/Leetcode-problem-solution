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
    int carryBit = 0;
    
    public ListNode plusOne(ListNode head) {
        head = helper(head);
        if (carryBit == 1) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }
    
    private ListNode helper(ListNode head) {
        //base case
        if (head == null) return null;
        if (head.next == null) {
            head.val += 1;
            if (head.val >= 10) {
                carryBit = 1;
                head.val -= 10;
                return head;
            }
        }
        
        head.next = helper(head.next);
        if (carryBit == 1) {
            head.val += 1;
            carryBit = 0;
            if (head.val >= 10) {
                carryBit = 1;
                head.val -= 10;
            }
        }
        return head;
    }
}
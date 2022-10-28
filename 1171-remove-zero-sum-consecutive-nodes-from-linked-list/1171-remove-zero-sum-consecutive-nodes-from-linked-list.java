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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int prefix = 0;
        for (ListNode p = dummy; p != null; p = p.next) {
            prefix += p.val;
            map.put(prefix, p);
        }
        prefix = 0;
        for (ListNode p = dummy; p != null; p = p.next) {
            prefix += p.val;
            p.next = map.get(prefix).next;
        }
        return dummy.next;
    }
}
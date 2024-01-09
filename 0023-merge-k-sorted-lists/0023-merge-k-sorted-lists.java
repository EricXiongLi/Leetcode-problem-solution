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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            dummy.next = cur;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
            dummy.next = cur;
            dummy = dummy.next;
        }
        return res.next;
    }
}
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
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque();
        ListNode cur = head;
        while (cur != null) {
            while (!dq.isEmpty() && dq.peek().val < cur.val) {
                dq.pop();
            }
            dq.push(cur);
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        cur = dummy;
        while (!dq.isEmpty()) {
            cur.next = dq.pollLast();
            cur = cur.next;
        }
        cur.next = null;
        
        // return dummy.next;
        return dummy.next;
        
        
    }
}
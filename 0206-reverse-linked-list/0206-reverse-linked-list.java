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
    public ListNode reverseList(ListNode head) {
        
        Stack<ListNode> stack = new Stack();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode dumb = new ListNode(-1);
        ListNode newHead = dumb;
        while (!stack.isEmpty()) {
            dumb.next = stack.pop();
            dumb = dumb.next;
        }
        dumb.next = null;
        return newHead.next;
    
    }
}
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //find the middle node
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        //reverse the second list
        
        slow = head;
        fast = reverse(fast);
        while (fast != null) {
            ListNode slowNext = slow.next;
            ListNode fastNext = fast.next;
            slow.next = fast;
            fast.next = slowNext;
            fast = fastNext;
            slow = slowNext;
        }
        
    }
    
    //1, 2, 3, 4, 5 -> 5, 4, 3, 2, 1
    public ListNode reverse(ListNode head) {
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
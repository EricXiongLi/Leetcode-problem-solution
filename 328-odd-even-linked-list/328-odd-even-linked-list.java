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
        ListNode odd = new ListNode();
        ListNode oddStart = odd;
        ListNode even = new ListNode();
        ListNode evenStart = even;
        ListNode cur = head;
        int i = 1;
        while (cur != null) {
            if (i % 2 != 0) {
                odd.next = cur;
                odd = odd.next;
            } else {
                even.next = cur;
                even = even.next;
            }
            cur = cur.next;
            i++;
        }
        even.next = null;
        odd.next = evenStart.next;
        return oddStart.next;
        
    }
}

//tc: O(n)
//sc: O(1)
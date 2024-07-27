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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head, second = head.next;
        ListNode prev = dummy;
        while (first != null && second != null) {
            ListNode nextFirst = second.next;
            prev.next = second;
            second.next = first;
            first.next = nextFirst;
            prev = first;
            if (nextFirst != null) {
                ListNode nextSecond = nextFirst.next;
                second = nextSecond;
            }
            first = nextFirst;
        }
        return dummy.next;
    }
}

//tc: O(n)
//sc: O(1)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode res= null;
        int carry = 0;
        while (s1.size() != 0 || s2.size() != 0 || carry != 0) {
            int val = 0;
            if (s1.size() != 0) val += s1.pop();
            if (s2.size() != 0) val += s2.pop();
            val += carry;
            ListNode cur = new ListNode(val % 10);
            carry = val / 10;
            cur.next = res;
            res = cur;
        }
        return res;
    }
}
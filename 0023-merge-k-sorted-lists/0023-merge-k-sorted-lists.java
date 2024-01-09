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
        if (lists.length == 0) {
            return null;
        }
        return partition(lists, 0, lists.length - 1);
    }
    
    public ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode sub1 = partition(lists, start, mid);
        ListNode sub2 = partition(lists, mid + 1, end);
        return mergeTwoList(sub1, sub2);
    }
    
    public ListNode mergeTwoList(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val < node2.val) {
            ListNode sub = mergeTwoList(node1.next, node2);
            node1.next = sub;
            return node1;
        } else {
            ListNode sub = mergeTwoList(node2.next, node1);
            node2.next = sub;
            return node2;
        }
    }
}

//tc: O(nlog(n))
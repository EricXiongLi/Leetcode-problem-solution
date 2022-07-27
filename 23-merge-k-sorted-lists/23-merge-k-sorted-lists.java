class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (pq.size() != 0) {
            ListNode top = pq.poll();
            cur.next = top;
            cur = cur.next;
            if (pq.size() == 0) break;
            if (top.next != null) pq.offer(top.next);
        }
        return dummy.next;
    }
}

//tc: O(nlogn)
//sc: O(k)
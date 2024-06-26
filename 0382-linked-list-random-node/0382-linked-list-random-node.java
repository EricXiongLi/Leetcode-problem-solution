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
    ListNode head;
    Random random = new Random();
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        ListNode p = head;
        int ans = 0;
        int i = 1;
        while (p != null) {
            if (random.nextInt(i) == 0) {
                ans = p.val;
            }
            p = p.next;
            i++;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
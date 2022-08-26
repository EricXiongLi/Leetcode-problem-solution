/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    
    public Node treeToDoublyList(Node root) {
        Node head = null, prev = null;
        if (root == null) return null;
        Node p = root;
        Deque<Node> stack = new ArrayDeque<>();
        
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (head == null) {
                head = cur;
            }
            
            if (prev != null) {
                prev.right = cur;
            }
            
            cur.left = prev;
            prev = cur;
            Node p2 = cur.right;
            while (p2 != null) {
                stack.push(p2);
                p2 = p2.left;
            }
        }
        head.left = prev;
        prev.right = head;
        return head;
    }
}
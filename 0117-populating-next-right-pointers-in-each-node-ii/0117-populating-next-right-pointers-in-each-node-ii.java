/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return root;
        }
        q.offer(root);
        
        while (!q.isEmpty()) {
            int sz = q.size();
            Node prev = null;
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                if (i == 0) {
                    prev = cur;
                } else if (i != sz - 1) {
                    prev.next = cur;
                    prev = cur;
                } else {
                    prev.next = cur;
                    cur.next = null;
                }
                
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        
        return root;
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        int level = 0;
        if (root == null) return 0;
        Queue<Node> q = new LinkedList();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int sz = q.size();
            level++;
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                if (cur.children != null) {
                    for (Node child : cur.children) {
                        q.offer(child);
                    }
                }
            }
        }
        
        return level;
    }
}

//tc: O(n)
//sc: O(n)
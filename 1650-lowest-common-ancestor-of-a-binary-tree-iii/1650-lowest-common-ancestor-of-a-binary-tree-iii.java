/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if (p.parent == null) {
            return p;
        }
        
        if (q.parent == null) {
            return q;
        }
        Node p1 = p, q1 = q;
        while (p1 != q1) {
            p1 = p1.parent == null ? q : p1.parent;
            q1 = q1.parent == null ? p : q1.parent;
        }
        
        return p1;
    }
}
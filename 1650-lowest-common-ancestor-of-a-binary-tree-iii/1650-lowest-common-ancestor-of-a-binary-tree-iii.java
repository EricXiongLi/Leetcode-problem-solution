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
        Node pointerA = p;
        Node pointerB = q;
        while (pointerA != pointerB) {
            pointerA = pointerA == null ? q : pointerA.parent;
            pointerB = pointerB == null ? p : pointerB.parent;
        }
        return pointerA;
    }
}
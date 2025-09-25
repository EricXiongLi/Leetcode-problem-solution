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
    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        int target = node.val;
        while (node.parent != null && node.parent.val < target) {
            node = node.parent;
        }

        return node.parent;
    }
}
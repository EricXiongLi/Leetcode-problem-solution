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
    Node prev;
    Node head;
    public Node treeToDoublyList(Node root) {
        prev = null;
        head = null;
        if (root == null) return null;
        inorderTraversal(root);
        prev.right = head;
        head.left = prev;
        return head;
    }
    
    private void inorderTraversal(Node root) {
        if (root == null) return;
        inorderTraversal(root.left);
        if (head == null) {
            head = root;
        }
        if (prev != null) {
            prev.right = root;
        }
        root.left = prev;
        prev = root;
        inorderTraversal(root.right);
    }
}
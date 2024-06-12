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
    Node head;
    Node prev;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        head = null;
        prev = null;
        
        inOrder(root);
        head.left = prev;
        prev.right = head;
        
        return head;
    }
    
    public void inOrder(Node cur) {
        if (cur != null) {
            inOrder(cur.left);
            
            if (prev == null) {
                head = cur;  
            } else {
                cur.left = prev;
                prev.right = cur;
            } 
            prev = cur;
            inOrder(cur.right);
        }
    }
}

// tc: O(n)
// sc: O(logn), the worst case: O(n)
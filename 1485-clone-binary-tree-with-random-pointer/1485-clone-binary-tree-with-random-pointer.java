/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    Map<Node, NodeCopy> map = new HashMap();
    
    public NodeCopy copyRandomBinaryTree(Node root) {
        return dfs(root);
    }
    
    public NodeCopy dfs(Node root) {
        if (root == null) {
            return null;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        NodeCopy copy = new NodeCopy(root.val);
        map.put(root, copy);
        copy.left = dfs(root.left);
        copy.right = dfs(root.right);
        copy.random = dfs(root.random);
        return copy;
    }
}

//tc: O(n)
//sc: O(n)
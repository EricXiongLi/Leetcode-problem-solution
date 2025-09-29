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
    Map<Node, NodeCopy> map = new HashMap<>();
    public NodeCopy copyRandomBinaryTree(Node root) {
        return dfs(root);
    }

    public NodeCopy dfs(Node root) {
        if (root == null) return null;
        if (map.containsKey(root)) return map.get(root);
        NodeCopy copy = new NodeCopy(root.val);
        map.put(root, copy);
        NodeCopy left = dfs(root.left);
        NodeCopy right = dfs(root.right);
        NodeCopy random = dfs(root.random);
        copy.left = left;
        copy.random = random;
        copy.right = right;
        return copy;
    }
}
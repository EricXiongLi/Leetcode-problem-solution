/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair res = maxDepth(root);
        return res.node;
    }
    
    private Pair maxDepth(TreeNode root) {
    if (root == null) {
        return new Pair(null, 0);
    }
    Pair left = maxDepth(root.left);
    Pair right = maxDepth(root.right);
    if (left.d == right.d) {
        return new Pair(root, left.d + 1);
    }
    return left.d > right.d ? new Pair(left.node, left.d + 1) : new Pair(right.node, right.d + 1);
}
}

class Pair {
    TreeNode node;
    int d;
    
    public Pair(TreeNode node, int d) {
        this.node = node;
        this.d = d;
    }
}







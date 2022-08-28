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
        Pair res = getLCA(root, 0);
        return res.node;
    }
    
    public Pair getLCA(TreeNode root, int d) {
        if (root == null) {
            return new Pair(null, d);
        }
        Pair left = getLCA(root.left, d + 1);
        Pair right = getLCA(root.right, d + 1);
        if (left.d == right.d) {
            return new Pair(root, left.d);
        } else {
            return left.d > right.d ? new Pair(left.node, left.d) : new Pair(right.node, right.d);
        }
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
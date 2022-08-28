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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
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
        }
        return left.d > right.d ? left : right;
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
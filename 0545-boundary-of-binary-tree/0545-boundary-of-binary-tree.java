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
    List<Integer> res = new ArrayList<>(1000);
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return res;
        res.add(root.val);
        left(root.left);
        leaves(root.left);
        leaves(root.right);
        right(root.right);
        return res;
    }

    public void left(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if (root.left != null) {
            left(root.left);
        } else {
            left(root.right);
        }
    }

    public void right(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.right != null) {
            right(root.right);
        } else {
            right(root.left);
        }
        res.add(root.val);
    }

    public void leaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        leaves(root.left);
        leaves(root.right);
    }
}
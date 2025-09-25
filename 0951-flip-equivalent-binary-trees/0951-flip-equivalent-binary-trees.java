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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null && root2 != null) {
            return false;
        } else if (root2 == null && root1 != null) {
            return false;
        }
        
        if (root1.val != root2.val) {
            return false;
        }
        if (isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right)) {
            return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        }

        if (isEqual(root1.left, root2.right) && isEqual(root1.right, root2.left)) {
            return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        }

        return false;
    }

    public boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null && node1.val == node2.val) {
            return true;
        }
        return false;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cursor = root;
        while (cursor != null) {
            if (p.val < cursor.val && q.val < cursor.val) {
                cursor = cursor.left;
            } else if (p.val > cursor.val && q.val > cursor.val) {
                cursor = cursor.right;
            } else {
                return cursor;
            }
        }
        return null;
    }
}
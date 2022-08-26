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
    public int closestValue(TreeNode root, double target) {
        TreeNode cur = root;
        int res = root.val;
        while (cur != null) {
            if (target == cur.val) {
                return cur.val;
            } else if (target < cur.val) {
                if (Math.abs(target - cur.val) < Math.abs(target - res)) {
                    res = cur.val;
                }
                cur = cur.left;
            } else {
                if (Math.abs(cur.val - target) < Math.abs(res - target)) {
                    res = cur.val;
                }
                cur = cur.right;
            }
        }
        
        return res;
    }
}
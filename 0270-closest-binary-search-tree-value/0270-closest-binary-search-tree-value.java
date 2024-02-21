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
        double diff = Double.MAX_VALUE;
        int res = 0;
        TreeNode node = root;
        while (node != null) {
            double curDiff = Math.abs(target - node.val);
            if (curDiff == diff) {
                res = Math.min(node.val, res);
            } else if (curDiff < diff) {
                res = node.val;
                diff = curDiff;
            }
            if (node.val == target) {
                return node.val;
            } else if (node.val > target) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        
        return res;
    }
}

//tc: O(h)
//sc: O(1);
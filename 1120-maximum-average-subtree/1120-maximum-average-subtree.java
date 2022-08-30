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
    double res = 0;
    public double maximumAverageSubtree(TreeNode root) {
        maxAverage(root);
        return res;
    }
    
    //[sum of subtree, # of nodes in this subtree]
    private int[] maxAverage(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        
        int[] left = maxAverage(root.left);
        int leftSum = left[0], leftNum = left[1];
        int[] right = maxAverage(root.right);
        int rightSum = right[0], rightNum = right[1];
        double cur = (double)(root.val + rightSum + leftSum) / (double)(1 + leftNum + rightNum);
        res = Math.max(cur, res);
        return new int[]{leftSum + rightSum + root.val, leftNum + rightNum + 1};
        
    }
}
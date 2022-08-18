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
    long res;
    int totalSum;
    public int maxProduct(TreeNode root) {
        res = 0;
        totalSum = getSum(root);
        getSum(root);
        return (int) (res % (1e9 + 7));
    }
    
    private int getSum(TreeNode root) {
        if (root == null) return 0;
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int rootSum = root.val + leftSum + rightSum;
        res = Math.max(res, (long) rootSum * (totalSum - rootSum));
        return rootSum;
    }
    
    
}
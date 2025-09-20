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
    int res;
    public int closestValue(TreeNode root, double target) {
        res = root.val;
        dfs(root, target);
        return res;
    }
    
    //seek for closest value;
    public void dfs(TreeNode root, double target) {
        if (root == null) return;
        if (Math.abs(res - target) > Math.abs(root.val - target) || (Math.abs(res - target) == Math.abs(root.val - target) && root.val < res)) {
                res = root.val;
            }
        if (root.val < target) {
            dfs(root.right, target);
        } else {
            dfs(root.left, target);
        }
    }
}

//tc: O(n)
//sc: O(h) -> O(n)
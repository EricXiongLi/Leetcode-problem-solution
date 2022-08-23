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
    int[] preorder;
    int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        index = 0;
        return dfs(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode dfs(int lower, int upper) {
        if (index == preorder.length) {
            return null;
        }
        int cur = preorder[index];
        if (cur < lower || cur > upper) {
            return null;
        }
        index++;
        TreeNode root = new TreeNode(cur);
        root.left = dfs(lower, cur);
        root.right = dfs(cur, upper);
        return root;
    }
}
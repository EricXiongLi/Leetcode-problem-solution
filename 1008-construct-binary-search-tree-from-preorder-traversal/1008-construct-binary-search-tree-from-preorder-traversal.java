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
        return dfs(0, preorder.length - 1);
    }
    
    private TreeNode dfs(int start, int end) {
        if (start > end || start >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = binarySearch(preorder[start], start + 1, end);
        root.left = dfs(start + 1, index - 1);
        root.right = dfs(index, end);
        return root;
    }
    
    private int binarySearch(int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (preorder[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
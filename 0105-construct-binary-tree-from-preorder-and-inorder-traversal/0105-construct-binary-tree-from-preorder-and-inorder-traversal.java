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
    Map<Integer, Integer> in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        in = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode dfs(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 > end1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start1]);
        int index = in.get(preorder[start1]);
        int leftSize = index - start2;
        root.left = dfs(preorder, start1 + 1, start1 + leftSize, inorder, start2, index - 1);
        root.right = dfs(preorder, start1 + leftSize + 1, end1, inorder, index + 1, end2);
        return root;
    }
}
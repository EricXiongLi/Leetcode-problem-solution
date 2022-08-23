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
    private Map<Integer, Integer> in;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = new HashMap<>();//val, index in inorder
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode dfs(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2) {
        if (start1 > end1) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[end2]);
        int leftSize = in.get(root.val) - start1;
        int index = in.get(root.val);
        root.left = dfs(inorder, start1, start1 + leftSize - 1, postorder, start2, start2 + leftSize - 1);
        root.right = dfs(inorder, index + 1, end1, postorder, start2 + leftSize, end2 - 1);
        return root;
    }
}
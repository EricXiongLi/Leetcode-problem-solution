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
    Map<Integer, Integer> postMap;
    int[] preorder;
    int[] postorder;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        postMap = new HashMap<>();
        this.preorder = preorder;
        this.postorder = postorder;
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        return dfs(0, preorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode dfs(int start1, int end1, int start2, int end2) {
        if (start1 == end1) {
            return new TreeNode(preorder[start1]);
        }
        if (start1 > end1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start1]);
        int index = postMap.get(root.val);
        int leftRoot = preorder[start1 + 1];
        int index2 = postMap.get(leftRoot);
        int leftSize = index2 - start2 + 1;
        root.left = dfs(start1 + 1, start1 + leftSize, start2, index2);
        root.right = dfs(start1 + leftSize + 1, end1, index2 + 1, end1 - 1);
        return root;
    }
}
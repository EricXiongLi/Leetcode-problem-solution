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
    Map<Long, Integer> map = new HashMap<>();//<prefix sum, frequency>
    long sum = (long)0;
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        map.put((long)0, 1);
        pathSumWithRoot(root, targetSum);
        return res;
    }
    
    public void pathSumWithRoot(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        res += map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        pathSumWithRoot(root.left, targetSum);
        pathSumWithRoot(root.right,  targetSum);
        map.put(sum, map.get(sum) - 1);
        if (map.get(sum) == 0) {
            map.remove(sum);
        }
        sum -= root.val;
    }
}
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        int minCol = 0, maxCol = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        //Pair<TreeNode, column>
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        
        //{0 -> [3], -1 -> [9]}
        q.offer(new Pair<>(root, 0));
        
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> cur = q.poll();
            
            TreeNode curNode = cur.getKey();
            int col = cur.getValue();
            minCol = Math.min(col, minCol);
            maxCol = Math.max(col, maxCol);
            map.putIfAbsent(col, new ArrayList<>());
            
            map.get(col).add(curNode.val);
            
            TreeNode left = curNode.left;
            TreeNode right = curNode.right;
            
            if (left != null) {
                q.offer(new Pair<>(left, col - 1));
            }
            
            if (right != null) {
                q.offer(new Pair<>(right, col + 1));
            }
        }
        
        
        for (int i = minCol; i <= maxCol; i++) {
            output.add(map.get(i));
        }
        
        return output;
    }
}

// tc: O(n)
// sc: O(n)
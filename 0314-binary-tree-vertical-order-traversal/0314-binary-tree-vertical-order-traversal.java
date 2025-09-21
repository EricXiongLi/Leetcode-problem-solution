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
        int minCol = 0, maxCol = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;
        q.offer(new Pair(0, root));

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            map.computeIfAbsent(cur.col, v -> new ArrayList<>()).add(cur.node.val);

            minCol = Math.min(cur.col, minCol);
            maxCol = Math.max(cur.col, maxCol);

            if (cur.node.left != null) {
                q.offer(new Pair(cur.col - 1, cur.node.left));
            }

            if (cur.node.right != null) {
                q.offer(new Pair(cur.col + 1, cur.node.right));
            }
        }

        

        for (int i = minCol; i <= maxCol; i++) {
            res.add(map.get(i));
        }

        return res;
    }
}

class Pair {
    int col;
    TreeNode node;

    public Pair(int col, TreeNode node) {
        this.col = col;
        this.node = node;
    }
}
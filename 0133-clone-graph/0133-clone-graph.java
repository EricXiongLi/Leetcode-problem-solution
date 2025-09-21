/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        visited.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            //Once the node is into teh queue, it will have complete neighbors

            for (Node nei : cur.neighbors) {
                if (!visited.containsKey(nei)) {
                    Node neiCopy = new Node(nei.val);
                    visited.put(nei, neiCopy);
                    q.offer(nei);
                }
                Node curCopy = visited.get(cur);
                curCopy.neighbors.add(visited.get(nei));
            }
        }

        return visited.get(node);
    }
}

//tc: O(E + V)
//sc: O(V)
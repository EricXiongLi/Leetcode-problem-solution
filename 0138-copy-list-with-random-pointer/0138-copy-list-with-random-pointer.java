/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> visited = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newNode = getClonedNode(head);
        Node oldNode = head;
        while (newNode != null) {
            newNode.next = this.getClonedNode(oldNode.next);
            newNode.random = this.getClonedNode(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        
        return getClonedNode(head);
    }
    
    public Node getClonedNode(Node node) {
        if (node == null) {
            return null;
        }
        visited.putIfAbsent(node, new Node(node.val, null, null));
        return visited.get(node);
    }
}

//tc: O(n)
//sc: O(n)
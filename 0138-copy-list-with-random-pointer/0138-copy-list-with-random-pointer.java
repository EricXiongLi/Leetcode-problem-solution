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
    public Node copyRandomList(Node head) {
        //1st round: insert duplicate node and assign "next" field and value
        Node p = head, copy;
        while (p != null) {
            copy = new Node(p.val, null, null);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        
        //2nd round: assign "random" field
        p = head;
        Node pRandom, copyRandom;
        while (p != null) {
            copy = p.next;
            pRandom = p.random;
            if (pRandom != null) {
                copy.random = pRandom.next;
            }
            p = p.next.next;
        }
        
        //3rd round: revert to initial status and extract copy list
        Node dummyHead = new Node(0, null, null), copyP = dummyHead;
        p = head;
        while (p != null) {
            Node nextNode = p.next.next;
            Node pCopy = p.next;
            copyP.next = pCopy;
            copyP = pCopy;
            p.next = nextNode;
            p = p.next;
        }
        
        return dummyHead.next;
    }
}

// tc: O(n)
// sc: O(1)
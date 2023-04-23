class LRUCache {
    Map<Integer, Node> map;
    DoubleLinkedList ddl;
    int cap;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
        ddl = new DoubleLinkedList();
    }
    
    public int get(int key) {
        //get the key from hashmap
        if (map.containsKey(key)) {
            Node foundNode = map.get(key);
            //update it as recently used -> return the val
           ddl.moveToHead(foundNode);
            return foundNode.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        //check it exists or not
        //yes: 1.update its value -> 2 move to head
        if (map.containsKey(key)) {
            Node foundNode = map.get(key);
            foundNode.val = value;
            ddl.moveToHead(foundNode);
        }  else {
            //no: 1.put it in the map -> 2.check whether the map's size exceeds the capacity
        
             //if yes: add the entry -> move the tail node out -> move to head
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            if (map.size() > cap) {
                Node tailNode = ddl.removeTailNode();
                map.remove(tailNode.key);
                
            }
            ddl.addToHead(newNode);
        }
        
        //no: add the entry-> move the new entry to list's head
    }
}

class Node {
    int val;
    int key;
    Node prev;
    Node next;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;
    
    public DoubleLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void moveToHead(Node foundNode) {
        Node prev = foundNode.prev;
        Node next = foundNode.next;
            prev.next = next;
            next.prev = prev;
        
        Node headNext = head.next;
        foundNode.prev = head;
        foundNode.next = headNext;
        head.next = foundNode;
        headNext.prev = foundNode;
    }
    
    public Node removeTailNode() {
        Node tailPrev = tail.prev;
        Node tailPrevPrev = tailPrev.prev;
        tailPrevPrev.next = tail;
        tail.prev = tailPrevPrev;
        return tailPrev;
    }
    
    public void addToHead(Node node) {
        Node headNext = head.next;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//tc: O(n)
//sc: O(1)
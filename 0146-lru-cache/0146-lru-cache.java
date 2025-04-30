class LRUCache {
    int cap;
    int count = 0;
    Map<Integer, Node> map;
    DoubleLinkedList dhl;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        dhl = new DoubleLinkedList();
        cap = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            dhl.moveToHead(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            dhl.moveToHead(node);
        } else {
            Node node = new Node(null, null, key, value);
            map.put(key, node);
            dhl.addToHead(node);
            count++;

            if (count > cap) {
                Node tail = dhl.removeTailNode();
                map.remove(tail.key);
                count--;
            }
        }
        
    }
}

class Node {
    Node prev;
    Node next;
    int val;
    int key;
    public Node(Node prev, Node next, int key, int val) {
        this.prev = prev;
        this.next = next;
        this.val = val;
        this.key = key;
    }
}

class DoubleLinkedList {
    Node headDummy;
    Node tailDummy;

    public DoubleLinkedList() {
        headDummy = new Node(null, null, -1, -1);
        tailDummy = new Node(headDummy, null, -1, -1);
        headDummy.next = tailDummy;
    }

    public void addToHead(Node node) {
        Node head = headDummy.next;
        node.next = head;
        node.prev = headDummy;
        headDummy.next = node;
        head.prev = node;
    }

    public void moveToHead(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;

        addToHead(node);
    }

    public Node removeTailNode() {
        Node tail = tailDummy.prev;
        Node tailPrev = tail.prev;
        tailPrev.next = tailDummy;
        tailDummy.prev = tailPrev;
        tail.next = null;
        return tail;
    }

    public Node removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */